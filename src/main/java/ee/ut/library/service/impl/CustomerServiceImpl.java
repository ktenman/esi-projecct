package ee.ut.library.service.impl;

import ee.ut.library.domain.entity.Authority;
import ee.ut.library.domain.entity.Customer;
import ee.ut.library.domain.entity.User;
import ee.ut.library.domain.dto.CustomerDto;
import ee.ut.library.exception.CustomerNotFoundException;
import ee.ut.library.exception.GeneralException;
import ee.ut.library.repository.CustomerRepository;
import ee.ut.library.security.repository.AuthorityRepository;
import ee.ut.library.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;

@Service
@AllArgsConstructor
@Transactional
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;
    private final UserServiceImpl userService;
    private final AuthorityRepository authorityRepository;

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Customer getOne(Long id) {
        return customerRepository.findById(id).orElseThrow(() -> new CustomerNotFoundException(id));
    }

    @Override
    public Customer insert(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Customer update(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public void deleteById(Long id) {
        customerRepository.deleteById(id);
    }

    @Override
    public CustomerDto save(CustomerDto customerDto) {
        List<Authority> authorities = authorityRepository.findByRoleIn(customerDto.getRoles());
        if (authorities.isEmpty()) {
            throw new GeneralException("No authorities found");
        }
        User user = new User(u -> saveOrUpdate(u, customerDto));
        user.setAuthorities(new HashSet<>(authorities));
        User savedUser = userService.insert(user);
        Customer customer = new Customer(c -> {
            c.setUser(savedUser);
            c.setIdCode(customerDto.getIdCode());
        });
        customerRepository.save(customer);
        customerDto.setUserId(savedUser.getId());
        return customerDto;
    }

    private User saveOrUpdate(User user, CustomerDto customerDto) {
        user.setUsername(customerDto.getUserName());
        user.setFirstName(customerDto.getFirstName());
        user.setLastName(customerDto.getLastName());
        user.setEmail(customerDto.getEmail());
        user.setPassword(customerDto.getPassWord());
        user.setActivated(customerDto.isActivated());
        user.setPhoneNumber(customerDto.getPhoneNumber());
        user.setAddress(customerDto.getAddress());
        return user;
    }

    @Override
    public CustomerDto update(CustomerDto customerDto) {
        User user = userService.getOne(customerDto.getUserId());
        List<Authority> authorities = authorityRepository.findByRoleIn(customerDto.getRoles());
        if (authorities.isEmpty()) {
            throw new GeneralException("No authorities found");
        }
        user.setAuthorities(new HashSet<>(authorities));
        userService.update(saveOrUpdate(user, customerDto));
        Customer customer = customerRepository.findByUser(user);
        if (customerDto.getIdCode().equals(customer.getIdCode()) &&
                customerDto.getFineAmount().equals(customer.getFineAmount())) {
            return customerDto;
        }
        customer.setIdCode(customerDto.getIdCode());
        customer.setFineAmount(customerDto.getFineAmount());
        customerRepository.save(customer);
        return customerDto;
    }
}

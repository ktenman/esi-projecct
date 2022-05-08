package ee.ut.library.service.impl;

import ee.ut.library.CustomerDto;
import ee.ut.library.domain.entity.Authority;
import ee.ut.library.domain.entity.Customer;
import ee.ut.library.domain.entity.User;
import ee.ut.library.exception.CustomerNotFoundException;
import ee.ut.library.exception.GeneralException;
import ee.ut.library.repository.CustomerRepository;
import ee.ut.library.repository.UserRepository;
import ee.ut.library.security.repository.AuthorityRepository;
import ee.ut.library.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;

@Service
@AllArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;
    private final UserRepository userRepository;
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
    @Transactional
    public CustomerDto save(CustomerDto customerDto) {
        List<Authority> authorities = authorityRepository.findByRoleIn(customerDto.getRoles());
        if (authorities.isEmpty()) {
            throw new GeneralException("No authorities found");
        }
        User user = new User(u -> {
            u.setUsername(customerDto.getUserName());
            u.setFirstName(customerDto.getFirstName());
            u.setLastName(customerDto.getLastName());
            u.setEmail(customerDto.getEmail());
            u.setPassword(customerDto.getPassWord());
            u.setActivated(customerDto.isActivated());
            u.setPhoneNumber(customerDto.getPhoneNumber());
            u.setAddress(customerDto.getAddress());
            u.setAuthorities(new HashSet<>(authorities));
        });
        User savedUser = userRepository.save(user);
        Customer customer = new Customer(c -> {
            c.setUser(savedUser);
            c.setIdCode(customerDto.getIdCode());
        });
        customerRepository.save(customer);
        customerDto.setUserId(savedUser.getId());
        return customerDto;
    }

    @Override
    public CustomerDto update(CustomerDto customerDto) {
        return null;
    }
}

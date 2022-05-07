package ee.ut.library.service.impl;

import ee.ut.library.domain.entity.Customer;
import ee.ut.library.exception.UserNotFoundException;
import ee.ut.library.repository.CustomerRepository;
import ee.ut.library.service.CustomerService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public List<Customer> getAll() {
        return customerRepository.findAll();
    }

    @Override
    public Customer get(Long id) {
        return customerRepository.findById(id).orElseThrow(UserNotFoundException::new);
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
    public void delete(Long id) {
        customerRepository.deleteById(id);
    }
}

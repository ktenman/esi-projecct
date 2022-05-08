package ee.ut.library.service;

import ee.ut.library.CustomerDto;
import ee.ut.library.domain.entity.Customer;

public interface CustomerService extends CrudService<Customer> {
    CustomerDto save(CustomerDto customerDto);

    CustomerDto update(CustomerDto customerDto);
}

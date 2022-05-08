package ee.ut.library.service;

import ee.ut.library.domain.entity.Customer;
import ee.ut.library.dto.CustomerDto;

public interface CustomerService extends CrudService<Customer> {
    CustomerDto save(CustomerDto customerDto);

    CustomerDto update(CustomerDto customerDto);
}

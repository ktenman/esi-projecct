package ee.ut.library.service.impl;

import ee.ut.library.domain.entity.Customer;
import ee.ut.library.repository.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CustomerServiceImplTest {

    @Mock
    CustomerRepository customerRepository;

    @InjectMocks
    CustomerServiceImpl customerService;

    @Test
    void get() {
        Long id = 222L;
        Customer expectedCustomer = new Customer(c -> c.setId(id));
        when(customerRepository.findById(id)).thenReturn(Optional.of(expectedCustomer));

        Customer actualCustomer = customerService.getOne(id);

        assertThat(actualCustomer.getId()).isEqualTo(id);
    }
}

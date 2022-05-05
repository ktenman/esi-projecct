package ee.ut.library.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import ee.ut.library.TestBase;
import ee.ut.library.domain.entity.Customer;
import ee.ut.library.repository.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import javax.annotation.Resource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class CustomerControllerIntegrationTest extends TestBase {
    @Resource
    MockMvc mockMvc;
    @Resource
    ObjectMapper objectMapper;
    @Resource
    CustomerRepository customerRepository;

    @Test
    void findAllCustomers() throws Exception {
        assertThat(customerRepository.findAll()).isEmpty();

        Customer customer = Customer.builder()
                .address("aasdfa")
                .email("sfda@fsda.com")
                .name("nanme")
                .phoneNumber("454353")
                .build();

        mockMvc.perform(post("/customers")
                        .contentType(APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(customer)))
                .andExpect(status().isOk());

        assertThat(customerRepository.findAll()).hasSize(1);
    }
}

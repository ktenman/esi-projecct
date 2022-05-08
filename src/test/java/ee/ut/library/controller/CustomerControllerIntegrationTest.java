package ee.ut.library.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import ee.ut.library.IntegrationTestBase;
import ee.ut.library.domain.entity.Customer;
import ee.ut.library.domain.entity.User;
import ee.ut.library.repository.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MockMvc;

import javax.annotation.Resource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class CustomerControllerIntegrationTest extends IntegrationTestBase {
    @Resource
    MockMvc mockMvc;
    @Resource
    ObjectMapper objectMapper;
    @Resource
    CustomerRepository customerRepository;

    @Test
    void findAllCustomers() throws Exception {
        assertThat(customerRepository.findAll()).isEmpty();

        Customer customer = new Customer(c -> {
            User user = new User();

            user.setAddress("aasdfa");
            user.setEmail("sfda@fsda.com");
            user.setFirstName("nanme");
            user.setPhoneNumber("454353");
            c.setUser(user);
            c.setIdCode("39506100250");
        });

        mockMvc.perform(post("/customers")
                        .contentType(APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(customer)))
                .andExpect(status().isOk());

        assertThat(customerRepository.findAll()).hasSize(1);
    }
}

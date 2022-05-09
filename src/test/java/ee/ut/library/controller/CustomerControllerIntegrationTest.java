package ee.ut.library.controller;

import ee.ut.library.IntegrationTestBase;
import ee.ut.library.domain.dto.CustomerDto;
import ee.ut.library.domain.enums.Role;
import ee.ut.library.repository.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.security.test.context.support.WithMockUser;

import javax.annotation.Resource;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WithMockUser(username = "John", authorities = {"CUSTOMER"})
class CustomerControllerIntegrationTest extends IntegrationTestBase {
    @Resource
    CustomerRepository customerRepository;

    @Test
    void insertCustomer() throws Exception {
        assertThat(customerRepository.findAll()).isEmpty();

        CustomerDto customerDto = CustomerDto.builder()
                .userName("ziya")
                .passWord("tofig")
                .firstName("siim")
                .lastName("delta")
                .email("siim@ut.ee")
                .address("asdasdsada")
                .phoneNumber("45464564")
                .idCode("39506100250")
                .roles(Set.of(Role.CUSTOMER))
                .build();

        mockMvc.perform(post("/customers")
                        .contentType(APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(customerDto)))
                .andExpect(status().isOk());

        assertThat(customerRepository.findAll()).hasSize(1);
    }

    @Test
    void updateCustomer() throws Exception {
        assertThat(customerRepository.findAll()).isEmpty();

        CustomerDto customerDto = CustomerDto.builder()
                .userName("ziya")
                .passWord("tofig")
                .firstName("siim")
                .lastName("delta")
                .email("siim@ut.ee")
                .address("asdasdsada")
                .phoneNumber("45464564")
                .idCode("39506100250")
                .roles(Set.of(Role.CUSTOMER))
                .build();

        String jsonResponse = mockMvc.perform(post("/customers")
                        .contentType(APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(customerDto)))
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();

        CustomerDto customerDtoResponse = objectMapper.readValue(jsonResponse, CustomerDto.class);

        mockMvc.perform(put("/customers")
                        .contentType(APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(customerDtoResponse)))
                .andExpect(status().isOk());

        assertThat(customerRepository.findAll()).hasSize(1);
    }
}

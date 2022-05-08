package ee.ut.library.controller;

import ee.ut.library.CustomerDto;
import ee.ut.library.domain.entity.Customer;
import ee.ut.library.service.CustomerService;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/customers")
public class CustomerController {
    private final CustomerService customerService;

    @GetMapping
    @ApiOperation(value = "Retrieves all customers")
    public List<Customer> getAll() {
        return customerService.findAll();
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Retrieves the customer by its id")
    public Customer get(@PathVariable Long id) {
        return customerService.getOne(id);
    }

    @PostMapping
    @ApiOperation(value = "Inserts new customer")
    public CustomerDto save(@Valid @RequestBody CustomerDto customerDto) {
        return customerService.save(customerDto);
    }

    @PutMapping
    @ApiOperation(value = "Updates the customer by its id")
    public CustomerDto update(@Valid @RequestBody CustomerDto customerDto) {
        return customerService.update(customerDto);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Delete the customer by its id")
    public void deleteById(@PathVariable Long id) {
        customerService.deleteById(id);
    }

}

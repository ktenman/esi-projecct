package ee.ut.library.controller;

import ee.ut.library.domain.entity.Customer;
import ee.ut.library.service.CustomerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@Api(value = "Operations related to user entity")
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    @ApiOperation(value = "Retrieves all users")
    public List<Customer> getAll() {
        return customerService.getAll();
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Retrieves the user by its id")
    public Customer get(@PathVariable Long id) {
        return customerService.get(id);
    }

    @PostMapping
    @ApiOperation(value = "Inserts new user")
    public Customer save(@Valid @RequestBody Customer customer) {
        return customerService.insert(customer);
    }
    @PutMapping
    @ApiOperation(value = "Updates the user by its id")
    public Customer update(@Valid @RequestBody Customer customer) {
        return customerService.update(customer);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Delete the user by its id")
    public void deleteById(@PathVariable Long id) {
        customerService.delete(id);
    }
}

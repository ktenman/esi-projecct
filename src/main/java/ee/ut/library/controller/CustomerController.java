package ee.ut.library.controller;

import ee.ut.library.domain.entity.Customer;
import ee.ut.library.domain.dto.CustomerDto;
import ee.ut.library.service.CustomerService;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/customers")
public class CustomerController {
    private final CustomerService customerService;

    @GetMapping
    @PreAuthorize("hasAuthority('CUSTOMER')")
    @ApiOperation(value = "Retrieves all customers")
    public List<Customer> getAll() {
        return customerService.findAll();
    }

    @PreAuthorize("hasAuthority('CUSTOMER')")
    @GetMapping("/{id}")
    @ApiOperation(value = "Retrieves the customer by its id")
    public Customer get(@PathVariable Long id) {
        return customerService.getOne(id);
    }

    @PreAuthorize("hasAuthority('CUSTOMER')")
    @PostMapping
    @ApiOperation(value = "Inserts new customer")
    public CustomerDto save(@Valid @RequestBody CustomerDto customerDto) {
        return customerService.save(customerDto);
    }

    @PreAuthorize("hasAuthority('CUSTOMER')")
    @PutMapping
    @ApiOperation(value = "Updates the customer by its id")
    public CustomerDto update(@Valid @RequestBody CustomerDto customerDto) {
        return customerService.update(customerDto);
    }

    @PreAuthorize("hasAuthority('CUSTOMER')")
    @DeleteMapping("/{id}")
    @ApiOperation(value = "Delete the customer by its id")
    public void deleteById(@PathVariable Long id) {
        customerService.deleteById(id);
    }

}

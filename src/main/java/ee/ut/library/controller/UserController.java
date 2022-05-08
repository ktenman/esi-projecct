package ee.ut.library.controller;

import ee.ut.library.domain.entity.User;
import ee.ut.library.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@Api(value = "Operations related to user entity")
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/current")
    public User getActualUser() {
        return userService.getUserWithAuthorities();
    }


    @GetMapping
    @ApiOperation(value = "Retrieves all users")
    public List<User> getAll() {
        return userService.getAll();
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Retrieves the user by its id")
    public User get(@PathVariable Long id) {
        return userService.get(id);
    }

    @PostMapping
    @ApiOperation(value = "Inserts new user")
    public User save(@Valid @RequestBody User user) {
        return userService.insert(user);
    }

    @PutMapping
    @ApiOperation(value = "Updates the user by its id")
    public User update(@Valid @RequestBody User user) {
        return userService.update(user);
    }

    @PreAuthorize("ROLE_USER")
    @DeleteMapping("/{id}")
    @ApiOperation(value = "Delete the user by its id")
    public void deleteById(@PathVariable Long id) {
        userService.delete(id);
    }
}

package ee.ut.library.controller;

import ee.ut.library.domain.entity.User;
import ee.ut.library.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@Api(value = "Operations related to user entity")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    @ApiOperation(value = "Retrieves all users")
    public List<User> getAll() {
        return userService.getAll();
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Retrieves the user by its id")
    public User get(@PathVariable UUID id) {
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

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Delete the user by its id")
    public void deleteById(@PathVariable UUID id) {
        userService.delete(id);
    }
}

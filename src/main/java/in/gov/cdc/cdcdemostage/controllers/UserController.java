package in.gov.cdc.cdcdemostage.controllers;

import in.gov.cdc.cdcdemostage.exception.ValidationException;
import in.gov.cdc.cdcdemostage.model.User;
import in.gov.cdc.cdcdemostage.validators.UserValidator;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private final UserValidator usernameValidator;

    public UserController(UserValidator usernameValidator) {
        this.usernameValidator = usernameValidator;
    }

    @PostMapping("/users")
    public User createUser(@RequestBody User user) throws ValidationException {
        // Associate the ValidatorVisitors with the UsernameValidator

        // Validate the user object
        usernameValidator.validateAndThrow(user.getName());


        return user;
    }
}

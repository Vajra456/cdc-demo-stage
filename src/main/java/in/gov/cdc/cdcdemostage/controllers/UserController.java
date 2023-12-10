package in.gov.cdc.cdcdemostage.controllers;

import in.gov.cdc.cdcdemostage.exception.ValidationException;
import in.gov.cdc.cdcdemostage.models.Event;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {


    @PostMapping("/users")
    public Event createUser(@RequestBody Event eventMessage) throws ValidationException {
        // Associate the ValidatorVisitors with the UsernameValidator

        return eventMessage;
    }
}

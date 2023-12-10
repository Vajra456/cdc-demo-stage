package in.gov.cdc.cdcdemostage.controllers;

import com.uidai.enu.common.model.EventMessage;
import in.gov.cdc.cdcdemostage.exception.ValidationException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {




    @PostMapping("/users")
    public EventMessage createUser(@RequestBody EventMessage eventMessage) throws ValidationException {
        // Associate the ValidatorVisitors with the UsernameValidator


        return eventMessage;
    }
}

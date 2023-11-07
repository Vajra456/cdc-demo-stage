package in.gov.cdc.cdcdemostage.validators;

import in.gov.cdc.cdcdemostage.exception.ValidationException;
import in.gov.cdc.cdcdemostage.model.User;


import java.util.HashMap;
import java.util.Map;

public class UserValidator implements Validator<User, String> {

    @Override
    public Map<String, String> validate(User user)
    {
        Map<String, String> errors = new HashMap<>();

        if (user.getName() == null || user.getName().isEmpty()) {
            errors.put("username", "Username is required");
        }

        if (!user.getPassword().matches("[a-zA-Z0-9]+")) {
            errors.put("password", "Password must contain only alphanumeric characters");
        }

        return errors;
    }
}

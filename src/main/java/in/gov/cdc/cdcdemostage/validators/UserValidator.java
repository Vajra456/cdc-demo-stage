package in.gov.cdc.cdcdemostage.validators;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@Component
public class UserValidator implements Validator<String, String> {
    @Override
    public Map<String, String> validate(String name) {
        Map<String, String> errors = new HashMap<>();

        if (name == null || name.isEmpty()) {
            errors.put("name", "Name is required");
        } else if (name.matches(".*\\d.*")) {
            errors.put("name", "Name cannot contain digits");
        }

        return errors;
    }

    public static class UserValidatorVisitor implements Validator.ValidatorVisitor {
        @Override
        public void visit(Validator validator) {
            if (validator instanceof UserValidator) {
                System.out.println("Visiting a NameValidator");
                // You can perform specific actions or configuration for NameValidator here
            }
        }
    }
}

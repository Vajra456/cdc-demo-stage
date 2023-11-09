package in.gov.cdc.cdcdemostage.validators;

import in.gov.cdc.cdcdemostage.model.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmailValidator implements Validator<User, String>  {

    private static final int BITMAP_EMAIL = 0x2;


    @Override
    public Map<String, String> validate(User object) {
        return null;
    }

    public static class EmailValidatorVisitor implements Validator.ValidatorVisitor {
        @Override
        public void visit(Validator validator) {
            if (validator instanceof EmailValidator) {
                System.out.println("Visiting an AgeValidator");
                // Specific actions or configuration for AgeValidator
            }
        }
    }
}


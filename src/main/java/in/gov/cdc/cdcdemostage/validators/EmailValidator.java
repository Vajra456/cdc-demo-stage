package in.gov.cdc.cdcdemostage.validators;

import in.gov.cdc.cdcdemostage.model.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmailValidator implements Validator<User, String>  {

    private static final int BITMAP_EMAIL = 0x2;


//    @Override
//    public List<Validator> filterValidators(List<Validator> validators, String object) {
//        return validators.stream()
//                .filter(validator -> validator.isApplicable(object))
//                .collect(Collectors.toList());
//    }


    @Override
    public Map<String, String> validate(User object) {
        return null;
    }
}


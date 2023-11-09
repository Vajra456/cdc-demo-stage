package in.gov.cdc.cdcdemostage.validators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class ValidatorFactory {

    @Autowired
    List<Validator> validators;


//    /**
//     * Returns a specific validator based on the object's class.
//     *
//     * @param object target object
//     * @return instance of {@link Validator}
//     */
//    public Validator getValidatorForObject(Object object) {
//        return validators.stream()
//                .filter(v -> v.supports(object.getClass())) // Assuming you have a method "supports" in the Validator interface
//                .findFirst()
//                .orElseThrow(() -> new GenericRuntimeException(ERROR_TYPE_VALIDATOR_NOT_FOUND.getText(
//                        object == null ? "null" : object.getClass().getName())));
//    }

    private Map<String, Validator.ValidatorVisitor> visitorRegistry = new HashMap<>();

    public void registerValidatorVisitor(String criteria, Validator.ValidatorVisitor visitor) {
        visitorRegistry.put(criteria, visitor);
    }

    public Validator.ValidatorVisitor getValidatorVisitor(String criteria) {
        return visitorRegistry.get(criteria);
    }
}
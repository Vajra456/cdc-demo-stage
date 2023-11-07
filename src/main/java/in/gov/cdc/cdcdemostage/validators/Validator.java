package in.gov.cdc.cdcdemostage.validators;

import in.gov.cdc.cdcdemostage.exception.ValidationException;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

@FunctionalInterface
public interface Validator<T, M extends Serializable> {
    /**
     * Validates target object
     *
     * @param object target object
     * @return map of errors (empty if valid)
     */
    Map<String, M> validate(T object);

    /**
     * Validates target object and throws exception in case
     * if list of errors is not empty
     *
     * @param object target object
     * @throws ValidationException if any validation errors exist
     */
    default void validateAndThrow(T object) throws ValidationException {
        Map<String, M> errors = validate(object);
        if (!errors.isEmpty()) {
            throw new ValidationException(errors);
        }
    }

    /**
     * Allows to configure validator if necessary
     *
     * @param visitor Validator visitor
     */
    default void configure(ValidatorVisitor visitor) {
        visitor.visit(this);
    }

    /**
     * Validator visitor functional interface
     */
    @FunctionalInterface
    interface ValidatorVisitor {

        /**
         * Action to be performed on a validator
         *
         * @param validator target validator
         */
        void visit(Validator validator);
    }
}

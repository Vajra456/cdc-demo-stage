package in.gov.cdc.cdcdemostage.exception;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class ValidationException extends RuntimeException {
    private final Map<String, ? extends Serializable> errors;

    public ValidationException(Map<String, ? extends Serializable> errors) {
        super("Validation errors occurred");
        this.errors = errors;
    }

    public Map<String, ? extends Serializable> getErrors() {
        return errors;
    }
}



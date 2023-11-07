package in.gov.cdc.cdcdemostage.exception;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class ValidationException <M extends Serializable> extends Exception{

    private final Map<String, M> errors;

    public ValidationException(Map<String, M> errors) {
        super("Validation failed");
        this.errors = errors;
    }

    public Map<String, M> getErrors() {
        return errors;
    }
}


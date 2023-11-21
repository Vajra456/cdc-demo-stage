package in.gov.cdc.cdcdemostage.validators;

import in.gov.cdc.cdcdemostage.models.EventMessage;

import java.util.List;

public interface IDataValidator {

    List<ValidationError> validate(EventMessage event);

}

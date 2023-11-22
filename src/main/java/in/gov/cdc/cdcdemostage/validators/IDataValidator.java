package in.gov.cdc.cdcdemostage.validators;

import in.gov.cdc.cdcdemostage.models.EventMessage;

import java.util.List;
import java.util.Optional;

public interface IDataValidator {

    List<Optional<ValidationError>> validate(EventMessage event);

}

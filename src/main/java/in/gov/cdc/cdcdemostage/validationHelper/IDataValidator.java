package in.gov.cdc.cdcdemostage.validationHelper;


import in.gov.cdc.cdcdemostage.models.Event;
import in.gov.cdc.cdcdemostage.models.ExtractedPacket;
import in.gov.cdc.cdcdemostage.models.ValidationError;

import java.util.List;
import java.util.Optional;

public interface IDataValidator {

    List<Optional<ValidationError>> validate(Event event, ExtractedPacket extractedPacket);

}

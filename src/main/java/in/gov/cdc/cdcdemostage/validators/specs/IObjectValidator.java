package in.gov.cdc.cdcdemostage.validators.specs;

import in.gov.cdc.cdcdemostage.models.Event;
import in.gov.cdc.cdcdemostage.models.ExtractedPacket;
import in.gov.cdc.cdcdemostage.models.ValidationError;

import java.util.BitSet;
import java.util.List;
import java.util.Optional;

public interface IObjectValidator {

    // This can be updated to consider other metadata
    boolean supports(BitSet b);

    // This defines the mode of the enrolment request i.e ONLINE or OFFLINE
    boolean mode (String mode);

    // This defines the kind of request ENROLLMENT, UPDATE, DELETE
    boolean requestType (String requestType);


    Optional<List<ValidationError>> validate(ExtractedPacket enrollmentPacket, Event eventMessage);

}

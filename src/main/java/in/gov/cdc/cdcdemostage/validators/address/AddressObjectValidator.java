package in.gov.cdc.cdcdemostage.validators.address;

import in.gov.cdc.cdcdemostage.models.Event;
import in.gov.cdc.cdcdemostage.models.ExtractedPacket;
import in.gov.cdc.cdcdemostage.models.ValidationError;
import in.gov.cdc.cdcdemostage.validators.specs.IObjectValidator;

import java.util.BitSet;
import java.util.List;
import java.util.Optional;

/**
 * This class orchestrates address validation rules against the incoming request
 * Outcome of the validation is captured in the bitmap for consumption at
 * later stages.
 */
public class AddressObjectValidator implements IObjectValidator {
    @Override
    public boolean supports(BitSet b) {
        return false;
    }

    @Override
    public boolean mode(String mode) {
        return true;
    }

    @Override
    public boolean requestType(String requestType) {
        return true;
    }

    @Override
    public Optional<List<ValidationError>> validate(ExtractedPacket enrollmentPacket, Event eventMessage) {
        return Optional.empty();
    }
}

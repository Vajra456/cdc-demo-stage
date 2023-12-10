package in.gov.cdc.cdcdemostage.validators.address;

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
    public String mode(String mode) {
        return null;
    }

    @Override
    public String requestType(String requestType) {
        return null;
    }

    @Override
    public Optional<List<ValidationError>> validate(ExtractedPacket enrollmentPacket, EventMessage eventMessage) {
        return Optional.empty();
    }
}

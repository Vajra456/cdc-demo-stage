package in.gov.cdc.cdcdemostage.validators.contact;

import in.gov.cdc.cdcdemostage.models.ValidationError;
import in.gov.cdc.cdcdemostage.validators.specs.IObjectValidator;
import org.springframework.stereotype.Component;

import java.util.BitSet;
import java.util.List;
import java.util.Optional;

/**
 * This method orchestrates contact validation code on the resident request.
 * Outcome of the validation is captured in the bitmap for rejection at a
 * later date.
 */
@Component
public class ContactObjectValidator implements IObjectValidator {
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

    /**
     * Entry method to orchstrate contact validation for the incoming request
     * @param enrollmentPacket
     * @param eventMessage
     * @return
     */
    @Override
    public Optional<List<ValidationError>> validate(ExtractedPacket enrollmentPacket, EventMessage eventMessage) {
        return Optional.empty();
    }
}

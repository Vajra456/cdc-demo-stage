package in.gov.cdc.cdcdemostage.validators.address.policy;

import in.gov.cdc.cdcdemostage.models.ExtractedPacket;
import in.gov.cdc.cdcdemostage.models.ValidationError;
import in.gov.cdc.cdcdemostage.validators.specs.IPolicyValidator;
import org.springframework.stereotype.Component;

import java.util.BitSet;
import java.util.Optional;

/**
 * This class validates the incoming request against the address update policy of UIDAI.
 * in this class availability of the document is performed based on the
 * request type and mode.
 */
@Component
public class AddressUpdatePolicy implements IPolicyValidator {
    @Override
    public boolean supports(BitSet b) {
        return false;
    }

    @Override
    public boolean mode(String mode) {
        return true;
    }

    @Override
    public Optional<ValidationError> validate(ExtractedPacket packet) {
        return Optional.empty();
    }

    /**
     * This method checks if the subject request is a HoF based request
     * and the address is same (full or partial) as that of the HoF.
     * @param packet
     * @return
     */
    private Optional<ValidationError> isHofBasedUpdate(ExtractedPacket packet) {
        return Optional.empty();
    }

    /**
     * This method checks for availability of the valid document in the subject request
     * for address verification. This is a point in time validation.
     */
    private Optional<ValidationError> isValidDocumentAvailable(ExtractedPacket packet) {
        return Optional.empty();
    }

}

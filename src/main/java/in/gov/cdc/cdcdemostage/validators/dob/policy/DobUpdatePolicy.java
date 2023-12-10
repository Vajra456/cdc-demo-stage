package in.gov.cdc.cdcdemostage.validators.dob.policy;

import in.gov.cdc.cdcdemostage.models.ExtractedPacket;
import in.gov.cdc.cdcdemostage.models.ValidationError;
import in.gov.cdc.cdcdemostage.validators.specs.IPolicyValidator;

import java.util.BitSet;
import java.util.Optional;

/**
 * This class implments the UIDAI policy on the age update rules.
 * It also handles the exception flow related to date update
 */
public class DobUpdatePolicy implements IPolicyValidator {
    @Override
    public boolean supports(BitSet b) {
        return false;
    }

    @Override
    public String mode(String mode) {
        return "ONLINE";
    }

    @Override
    public Optional<ValidationError> validate(ExtractedPacket data) {
        // Check if the number of updates undertaken by the resident is greater than business defined parameters
        return Optional.empty();
    }
}

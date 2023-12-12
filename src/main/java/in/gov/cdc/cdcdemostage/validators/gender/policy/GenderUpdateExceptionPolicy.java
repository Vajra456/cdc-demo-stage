package in.gov.cdc.cdcdemostage.validators.gender.policy;

import in.gov.cdc.cdcdemostage.models.ExtractedPacket;
import in.gov.cdc.cdcdemostage.models.ValidationError;
import in.gov.cdc.cdcdemostage.validators.specs.IPolicyValidator;

import java.util.BitSet;
import java.util.Optional;

/**
 * This class handles the exception policy on the Gender update.
 * Unlike Dob, it a separate class to check the applicability of the Gender update
 * ex eption policy
 */
public class GenderUpdateExceptionPolicy implements IPolicyValidator {
    @Override
    public boolean supports(BitSet b) {
        return false;
    }

    @Override
    public boolean mode(String mode) {
        return true;
    }

    /**
     * Entry method to validate the applicability of exception policy
     * on the Gender update request
     */
    @Override
    public Optional<ValidationError> validate(ExtractedPacket data) {
        return Optional.empty();
    }
}

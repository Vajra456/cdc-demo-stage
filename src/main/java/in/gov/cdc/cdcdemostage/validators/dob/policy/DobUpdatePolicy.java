package in.gov.cdc.cdcdemostage.validators.dob.policy;

import in.gov.cdc.cdcdemostage.models.ExtractedPacket;
import in.gov.cdc.cdcdemostage.models.ValidationError;
import in.gov.cdc.cdcdemostage.validators.specs.IPolicyValidator;

import java.util.BitSet;
import java.util.Optional;

import static in.gov.cdc.cdcdemostage.constant.Constants.OFFLINE;
import static in.gov.cdc.cdcdemostage.constant.Constants.ONLINE;

/**
 * This class implments the UIDAI policy on the age update rules.
 * It also handles the exception flow related to date update
 */
public class DobUpdatePolicy implements IPolicyValidator {
    @Override
    public boolean supports(BitSet b) {
        return b.get(5) || b.get(13);           // Check the applicability of this validator
    }

    /**
     * This class is used to validate the date syntax for both ONLINE and OFFLINE mode
     * @param mode
     * @return
     */
    @Override
    public boolean mode(String mode) {
        return mode.equals(ONLINE) || mode.equals(OFFLINE);
    }

    @Override
    public Optional<ValidationError> validate(ExtractedPacket data) {
        // Check if the number of updates undertaken by the resident is greater than business defined parameters
        return Optional.empty();
    }
}

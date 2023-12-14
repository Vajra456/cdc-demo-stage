package in.gov.cdc.cdcdemostage.validators.dob.policy;


import in.gov.cdc.cdcdemostage.models.ExtractedPacket;
import in.gov.cdc.cdcdemostage.models.ValidationError;
import in.gov.cdc.cdcdemostage.validators.specs.IPolicyValidator;
import org.springframework.stereotype.Component;

import java.util.BitSet;
import java.util.Optional;

import static in.gov.cdc.cdcdemostage.constant.Constants.OFFLINE;
import static in.gov.cdc.cdcdemostage.constant.Constants.ONLINE;

/**
 * This class handles the Dob conversion from Approximate/Declared to Verified status.
 * Prevents downward revision of Dob from Verified to Approximate/Declared
 */
@Component
public class DobConversionPolicy implements IPolicyValidator {

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
        ValidationError validationError = null;
//        if (data.getYear() < 1800) {        /** This is dummy codee **/
//            validationError.setErrorMessage( new BitSet(3)., "DoD process validation failed ,dod year is before 1800");
//        }
        return Optional.of(validationError);
    }
}

package in.gov.cdc.cdcdemostage.validators.dob.policy;


import in.gov.cdc.cdcdemostage.models.ExtractedPacket;
import in.gov.cdc.cdcdemostage.models.ValidationError;
import in.gov.cdc.cdcdemostage.validators.specs.IPolicyValidator;
import org.springframework.stereotype.Component;

import java.util.BitSet;
import java.util.Optional;

/**
 * This class handles the Dob conversion from Approximate/Declared to Verified status.
 * Prevents downward revision of Dob from Verified to Approximate/Declared
 */
@Component
public class DobConversionPolicy implements IPolicyValidator {



    @Override
    public boolean supports(BitSet b) {
        return true;
    }

    @Override
    public String mode(String mode) {
        return "ONLINE";
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

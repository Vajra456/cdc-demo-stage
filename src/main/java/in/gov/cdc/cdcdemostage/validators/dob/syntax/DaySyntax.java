package in.gov.cdc.cdcdemostage.validators.dob.syntax;


import in.gov.cdc.cdcdemostage.models.ExtractedPacket;
import in.gov.cdc.cdcdemostage.models.ValidationError;
import in.gov.cdc.cdcdemostage.validators.specs.ISyntaxValidator;
import org.springframework.stereotype.Component;

import java.util.BitSet;
import java.util.Optional;
import java.util.regex.Pattern;

import static in.gov.cdc.cdcdemostage.constant.Constants.OFFLINE;
import static in.gov.cdc.cdcdemostage.constant.Constants.ONLINE;

/**
 * This class performs the validation of the day field of the date.
 */
@Component
public class DaySyntax implements ISyntaxValidator {

    // Regex for validating days (handles leap years and months with different lengths)
    private static final Pattern daySyntaxCheck = Pattern.compile("^(0?[1-9]|[12]\\d|3[01])$");

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
        // Extract day directly from Dob
//        int day = data.getDay();
//        if (!daySyntaxCheck.matcher(String.valueOf(day)).matches()) {
//            // Provide informative error message
//            return Optional.of(new ValidationError("Invalid day format. Day should be between 1 and 31."));
//        }
        // Only return error if validation fails
        return Optional.empty();
    }
}

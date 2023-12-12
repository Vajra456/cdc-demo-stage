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
 * This class validates the year field of the date
 */
@Component
public class YearSyntax implements ISyntaxValidator {

    // This  regular expression (regex) that can be used to validate year in the yyyy format.
    public static final Pattern yearSyntaxCheck = Pattern.compile("^\\d{4}$");

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
//        Matcher matcher = yearSyntaxCheck.matcher(ExtractedPacket.getYear().toString());
//        if (matcher.matches()) {
//            validationError.setErrorMessage("Date syntax validation fail, not a valid year");
//            return Optional.of(validationError);
//        }

        return Optional.of(validationError);
    }
}

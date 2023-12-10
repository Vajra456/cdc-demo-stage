package in.gov.cdc.cdcdemostage.validators.dob.syntax;

import in.gov.cdc.cdcdemostage.models.ExtractedPacket;
import in.gov.cdc.cdcdemostage.models.ValidationError;
import in.gov.cdc.cdcdemostage.validators.specs.ISyntaxValidator;
import org.springframework.stereotype.Component;

import java.util.BitSet;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * This class performs the syntax validation on the Date field. This can be converted to an
 * abstract class for validation fo all kinds of the date
 */
@Component
public class DateSyntaxValidator  implements ISyntaxValidator {

    // This  regular expression (regex) that can be used to validate year in the yyyy format.
    public static final Pattern yearSyntaxCheck = Pattern.compile("^\\d{4}$");

    // This  regular expression (regex) that can be used to validate month in the MM format.
    public static final Pattern monthSyntaxCheck = Pattern.compile("^(0?[1-9]|1[0-2])$");

    // This  regular expression (regex) that can be used to validate day in the dd format.
    public static final Pattern daySyntaxCheck = Pattern.compile("^(0?[1-9]|[1-2]\\d|3[01])$");

    public ValidationError isYearSyntaxCheck(Integer year){
        ValidationError validationError = null;
        Matcher matcher = yearSyntaxCheck.matcher(year.toString());
        if (matcher.matches()) {
            validationError.setErrorMessage("Date syntax validation fail, not a valid year");
            return validationError;
        }
        return validationError;
    }

    public ValidationError isMonthSyntaxCheck(Integer month){
        ValidationError validationError = null;
        Matcher matcher = monthSyntaxCheck.matcher(month.toString());
        if (matcher.matches()) {
            validationError.setErrorMessage("Date syntax validation fail,month is not valid");
            return validationError;
        }
        return validationError;
    }

    public ValidationError isDaySyntaxCheck(Integer day){
        ValidationError validationError = null;
        Matcher matcher = daySyntaxCheck.matcher(day.toString());
        if (matcher.matches()) {
            validationError.setErrorMessage("Date syntax validation fail, not a valid day");
            return validationError;
        }
        return validationError;
    }

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
        return Optional.empty();
    }
    /**
     * Prepare the validation for Guardian's ID Type. Guardian ID ie:uid or eid
     * Type must be non-empty
     */

    /**
     * Prepare the validation that relation type cannot be empty
     * with the child
     */
    }

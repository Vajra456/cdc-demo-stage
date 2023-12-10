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
 * This class validates the year field of the date
 */
@Component
public class YearSyntax implements ISyntaxValidator {

    // This  regular expression (regex) that can be used to validate year in the yyyy format.
    public static final Pattern yearSyntaxCheck = Pattern.compile("^\\d{4}$");

    @Override
    public boolean supports(BitSet b) {
        return b.get(3)||b.get(14);
    }

    @Override
    public String mode(String mode) {
        return "ONLINE";
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

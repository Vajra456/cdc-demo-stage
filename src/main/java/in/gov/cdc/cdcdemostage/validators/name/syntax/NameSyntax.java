package in.gov.cdc.cdcdemostage.validators.name.syntax;

import in.gov.cdc.cdcdemostage.models.ExtractedPacket;
import in.gov.cdc.cdcdemostage.models.ValidationError;
import in.gov.cdc.cdcdemostage.validators.specs.ISyntaxValidator;
import org.springframework.stereotype.Component;

import java.util.BitSet;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * This class checks name syntax and if there are any syntx related errors
 * request would be rejected
 */
@Component
public class NameSyntax implements ISyntaxValidator {
    // This regular expression is used to match any character that is not a lowercase letter (a-z), an uppercase letter (A-Z), a period (.), a space ( ), or a single quote (').
    public static final Pattern basicNameCheck =Pattern.compile("[^a-zA-Z. ']+");

    // This regular expression is used to match two or more consecutive whitespace characters in a string.
    public static final Pattern spaceCheck = Pattern.compile("\\s{2,}");

    // This regular expression is used to match one or more consecutive periods in a string.
    public static final Pattern dotCheck = Pattern.compile("\\.\\.+");

    // This regular expression is used to match any leading or trailing whitespace in a string.
    public static final Pattern prePostSpaceCheck = Pattern.compile("^\\s+|\\s+$");



    @Override
    public boolean supports(BitSet b) {
        return false;
    }

    @Override
    public String mode(String mode) {
        return "ONLINE";
    }


    public ValidationError isBasicNameCheck(String name){
        ValidationError result = null;
        Matcher matcher = basicNameCheck.matcher(name);
        if (matcher.matches()) {
            result.setErrorMessage("Basic name syntax validation fail");
            return result;
        }
        return result;
    }

    public ValidationError isSpaceCheck(String text){
        ValidationError result = null;
        Matcher matcher = spaceCheck.matcher(text);
        if (matcher.matches()) {
            result.setErrorMessage("Space check validation fail");
            return result;
        }
        return result;
    }
    public ValidationError isDotCheck(String text){
        ValidationError result = null;
        Matcher matcher = dotCheck.matcher(text);
        if (matcher.matches()) {
            result.setErrorMessage("Dot check validation fail");
            return result;
        }
        return result;
    }
    public ValidationError isPrePostSpaceCheck(String text){
        ValidationError result = null;
        Matcher matcher = prePostSpaceCheck.matcher(text);
        if (matcher.matches()) {
            result.setErrorMessage("PrePostSpaceCheck validation fail");
            return result;
        }
        return result;
    }



    @Override
    public Optional<ValidationError> validate(ExtractedPacket data) {

        return Optional.empty();
    }
}

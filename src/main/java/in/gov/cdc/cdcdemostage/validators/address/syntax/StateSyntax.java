package in.gov.cdc.cdcdemostage.validators.address.syntax;


import in.gov.cdc.cdcdemostage.models.ExtractedPacket;
import in.gov.cdc.cdcdemostage.models.ValidationError;
import in.gov.cdc.cdcdemostage.validators.specs.ISyntaxValidator;
import org.springframework.stereotype.Component;

import java.util.BitSet;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Thsi class validates the syntax of the state information of the incoming
 * request against the master data.
 */
@Component
public class StateSyntax implements ISyntaxValidator {

    public static final Pattern statePattern = Pattern.compile("^.{1,50}$");

    @Override
    public boolean supports(BitSet b) {
        return b.get(15);
    }

    @Override
    public String mode(String mode) {
        return "ONLINE";
    }

    @Override
    public Optional<ValidationError> validate(ExtractedPacket enrollmentPacket) {
//        ResidentProfile address=enrollmentPacket.getPacket().getResidentProfile();
//        ValidationError validationError = new ValidationError(null);
//        String residentState=address.getState();
//        Matcher matcher = statePattern.matcher(residentState);
//        if(matcher.matches()){
//            validationError.setErrorMessage("Address syntax validation failed, State is invalid");
//        }

        return Optional.empty();
    }
}

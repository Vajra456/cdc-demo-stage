package in.gov.cdc.cdcdemostage.validators.address.syntax;


import in.gov.cdc.cdcdemostage.models.ExtractedPacket;
import in.gov.cdc.cdcdemostage.models.ValidationError;
import in.gov.cdc.cdcdemostage.validators.specs.ISyntaxValidator;
import org.springframework.stereotype.Component;

import java.util.BitSet;
import java.util.Optional;
import java.util.regex.Pattern;

/**
 * This class performs pincode syntax validation on the incoming request
 */
@Component
public class PinCodeSyntax implements ISyntaxValidator {

    public static final Pattern pincodePattern = Pattern.compile("^\\d{6}$");

    @Override
    public boolean supports(BitSet b) {
        return b.get(15);
    }

    @Override
    public boolean mode(String mode) {
        return true;
    }

    @Override
    public Optional<ValidationError> validate(ExtractedPacket enrollmentPacket) {
//        ResidentProfile address=enrollmentPacket.getPacket().getResidentProfile();
//        ValidationError validationError = new ValidationError(null);
//        String residentPincode=address.getPincode();
//        Matcher matcher = pincodePattern.matcher(residentPincode);
//        if(matcher.matches()){
//            validationError.setErrorMessage("Address syntax validation failed, pincode is invalid");
//        }
//        return Optional.of(validationError);

        return Optional.empty();
    }
}

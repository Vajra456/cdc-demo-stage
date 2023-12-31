package in.gov.cdc.cdcdemostage.validators.address.syntax;


import in.gov.cdc.cdcdemostage.models.ExtractedPacket;
import in.gov.cdc.cdcdemostage.models.ValidationError;
import in.gov.cdc.cdcdemostage.validators.specs.ISyntaxValidator;
import org.springframework.stereotype.Component;

import java.util.BitSet;
import java.util.Optional;
import java.util.regex.Pattern;

/**
 * This class implements Vtc syntnx validation against the incoming request.
 */
@Component
public class VtcSyntax implements ISyntaxValidator {
    public static final Pattern vtcPattern = Pattern.compile("^.{8,50}$");

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
//        String residentVtc=address.getVtc();
//        Matcher matcher = vtcPattern.matcher(residentVtc);
//        if(matcher.matches()){
//            validationError.setErrorMessage("Address syntax validation failed, VTC is invalid");
//        }

        return Optional.empty();
    }
}

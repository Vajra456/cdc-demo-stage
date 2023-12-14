package in.gov.cdc.cdcdemostage.validators.address.syntax;

import in.gov.cdc.cdcdemostage.models.ExtractedPacket;
import in.gov.cdc.cdcdemostage.models.ValidationError;
import in.gov.cdc.cdcdemostage.validators.specs.ISyntaxValidator;
import org.springframework.stereotype.Component;

import java.util.BitSet;
import java.util.Optional;
import java.util.regex.Pattern;

@Component
public class DistrictSyntax implements ISyntaxValidator {
    public static final Pattern districtPattern = Pattern.compile("^.{1,50}$");

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
//        String residentDistrict= address.getDistrict();
//        Matcher matcher = districtPattern.matcher(residentDistrict);
//        if(matcher.matches()){
//            validationError.setErrorMessage("Address syntax validation failed, District is invalid");
//        }
        return Optional.empty();
    }
}

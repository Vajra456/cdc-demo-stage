package in.gov.cdc.cdcdemostage.validators.contact.syntax;


import in.gov.cdc.cdcdemostage.models.ExtractedPacket;
import in.gov.cdc.cdcdemostage.models.ValidationError;
import in.gov.cdc.cdcdemostage.validators.specs.ISyntaxValidator;

import java.util.BitSet;
import java.util.Optional;
import java.util.regex.Pattern;


public class MobileSyntaxValidator implements ISyntaxValidator {

    // This regular expression ensures that the mobile number starts with 6, 7, 8, or 9 as per the TRAI guidelines and can be preceded by 0 or 91.
    public static final Pattern indianMobileCheck =  Pattern.compile("^(0|91)?[6-9][0-9]{9}$");
    @Override
    public boolean supports(BitSet bitSet) {
        return bitSet.get(9);
    }
    @Override
    public boolean mode(String mode){
        return true;
    }

    /**
     * our mob val codes go here
     * TODO : ISD to Country mapping check
     * TODO : All ISD code with there number characteristics like length, limits to different digits
     */
    @Override
    public Optional<ValidationError> validate(ExtractedPacket extractedPacket) {
//        String mobileNumber=extractedPacket.getPacket().getResidentProfile().getMobile();
//        if(mobileNumber==null)
//            return Optional.of(null);
//        ValidationError result = new ValidationError(null);
//        Matcher matcher = indianMobileCheck.matcher(mobileNumber);
//        if (matcher.matches()) {
//            result.setErrorMessage("Indian mobile number check validation fail");
//            return Optional.of(result);
//        }
        return Optional.empty();
    }
}

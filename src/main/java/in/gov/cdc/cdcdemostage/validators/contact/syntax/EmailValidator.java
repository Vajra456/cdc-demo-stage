package in.gov.cdc.cdcdemostage.validators.contact.syntax;

import in.gov.cdc.cdcdemostage.models.ExtractedPacket;
import in.gov.cdc.cdcdemostage.models.ValidationError;
import in.gov.cdc.cdcdemostage.validators.specs.ISyntaxValidator;
import org.springframework.stereotype.Component;

import java.util.BitSet;
import java.util.Optional;

@Component
public class EmailValidator implements ISyntaxValidator {

    @Override
    public boolean supports(BitSet bitSet) {
        return bitSet.get(9);
    }
    @Override
    public String mode(String mode){
        return "ONLINE";
    }

    @Override
    public Optional<ValidationError> validate(ExtractedPacket packet) {
        ValidationError result= null;
//        String ResidentEmail=packet.getEmail();
//        if(ResidentEmail==null){
//            return Optional.of(null);
//        }
//        boolean isValid = org.apache.commons.validator.routines.EmailValidator.getInstance().isValid(ResidentEmail);
//        if( ResidentEmail!=null && !isValid){
//            result=new ValidationError( "Email validation failed");
//        }
        return Optional.of(result);
    }

}

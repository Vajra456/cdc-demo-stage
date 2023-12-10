package in.gov.cdc.cdcdemostage.validators.gender.syntax;


import in.gov.cdc.cdcdemostage.models.ExtractedPacket;
import in.gov.cdc.cdcdemostage.models.ValidationError;
import in.gov.cdc.cdcdemostage.validators.specs.ISyntaxValidator;

import java.util.BitSet;
import java.util.Optional;

/**
 *
 */
public class GenderSyntax implements ISyntaxValidator {
    @Override
    public boolean supports(BitSet bitSet) {
        return bitSet.get(5);
    }

    @Override
    public String mode(String mode) {
        return "ONLINE";
    }

    /**
     * Entry method to validate the age
     * @param gender
     * @return
     */
    @Override
    public Optional<ValidationError> validate(ExtractedPacket gender) {
//        if(extractedPacket.getPacket().getResidentProfile().getGender()==null){
//            return Optional.of(new ValidationError("Gender cannot be null"));
//        }
        return Optional.empty();
    }

    /**
     * This method checks whether the gender is valid or not as per the UIDAI enum
     * @param gender
     * @return
     */
    private Optional<ValidationError> isValidGender(String gender){
        return Optional.empty();
    }
}

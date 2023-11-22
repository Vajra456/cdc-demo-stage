package in.gov.cdc.cdcdemostage.validators;

import in.gov.cdc.cdcdemostage.models.UidV2Data;
import org.springframework.stereotype.Component;

import java.util.BitSet;
import java.util.Optional;

@Component
class ResidentNameValidator implements IValidator {

    private String residentName;

    @Override
    public boolean supports(BitSet bitSet) {
        // if bitset contains resident name update
        return bitSet.get(1);
    }

    @Override
    public Optional<ValidationError> validate(UidV2Data[] uidV2Data) {
        residentName = getResidentName(uidV2Data);
        // applicable validations
        return Optional.empty();
    }

    private String getResidentName(UidV2Data[] uidV2Data){
        // get name from uidv2data
        return null;
    }
}

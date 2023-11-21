package in.gov.cdc.cdcdemostage.validators;

import in.gov.cdc.cdcdemostage.models.UidV2Data;

import java.util.BitSet;

//Spring component
class ResidentNameValidator implements IValidator {

    private String residentName;

    @Override
    public boolean supports(BitSet bitSet) {
        // if bitset contains resident name update
        return false;
    }

    @Override
    public ValidationError validate(UidV2Data[] uidV2Data) {
        residentName = getResidentName(uidV2Data);
        // applicable validations
        return null;
    }

    private String getResidentName(UidV2Data[] uidV2Data){
        // get name from uidv2data
        return null;
    }
}

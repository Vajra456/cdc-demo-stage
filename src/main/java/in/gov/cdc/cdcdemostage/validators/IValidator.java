package in.gov.cdc.cdcdemostage.validators;

import in.gov.cdc.cdcdemostage.models.UidV2Data;

import java.util.BitSet;
import java.util.Optional;

interface IValidator {

    // This can be updated to consider other metadata
    boolean supports(BitSet b);

    Optional<ValidationError> validate(UidV2Data[] uidV2Data);

}

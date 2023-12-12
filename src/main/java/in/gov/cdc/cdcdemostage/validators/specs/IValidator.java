package in.gov.cdc.cdcdemostage.validators.specs;

import in.gov.cdc.cdcdemostage.models.ExtractedPacket;
import in.gov.cdc.cdcdemostage.models.ValidationError;

import java.util.BitSet;
import java.util.Optional;

public interface IValidator {
    boolean supports(BitSet b);

    boolean mode(String mode);

    Optional<ValidationError> validate(ExtractedPacket data);
}

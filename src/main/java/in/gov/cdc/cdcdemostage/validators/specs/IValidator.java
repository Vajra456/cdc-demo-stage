package in.gov.cdc.cdcdemostage.validators.specs;

import in.gov.cdc.cdcdemostage.models.ValidationError;

import java.util.BitSet;
import java.util.Optional;

public interface IValidator {
    boolean supports(BitSet b);

    String mode(String mode);

    Optional<ValidationError> validate(ExtractedPacket data);
}

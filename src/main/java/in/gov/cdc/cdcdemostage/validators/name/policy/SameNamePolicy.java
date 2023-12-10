package in.gov.cdc.cdcdemostage.validators.name.policy;

import in.gov.cdc.cdcdemostage.models.ExtractedPacket;
import in.gov.cdc.cdcdemostage.models.ValidationError;
import in.gov.cdc.cdcdemostage.validators.specs.IPolicyValidator;

import java.util.BitSet;
import java.util.Optional;

/**
 * This class checks teh current name vis-a-vis existing name in the UIDv2master
 * If the name is same the request is to be rejected.
 */
public class SameNamePolicy implements IPolicyValidator {

    @Override
    public boolean supports(BitSet b) {
        return false;
    }

    @Override
    public String mode(String mode) {
        return "ONLINE";
    }

    @Override
    public Optional<ValidationError> validate(ExtractedPacket data) {
        return Optional.empty();
    }
}

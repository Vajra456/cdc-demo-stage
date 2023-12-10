package in.gov.cdc.cdcdemostage.validators.name.policy;

import in.gov.cdc.cdcdemostage.models.ExtractedPacket;
import in.gov.cdc.cdcdemostage.models.ValidationError;
import in.gov.cdc.cdcdemostage.validators.specs.IPolicyValidator;
import org.springframework.stereotype.Component;

import java.util.BitSet;
import java.util.Optional;

/**
 * This class checks if the current anme update request is later to another update
 * which has already been actioned. In that case, current request is to be treated
 * as null and void.
 */
@Component
public class LaterUpdateNameHandler implements IPolicyValidator{
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

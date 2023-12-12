package in.gov.cdc.cdcdemostage.validators.name.policy;

import in.gov.cdc.cdcdemostage.models.ExtractedPacket;
import in.gov.cdc.cdcdemostage.models.ValidationError;
import in.gov.cdc.cdcdemostage.validators.specs.IPolicyValidator;
import org.springframework.stereotype.Component;

import java.util.BitSet;
import java.util.Optional;

/**
 * This class checks availability of the supporting document for the
 * name provided as part of the enrolment or update.
 * It also checks for the Introducer based name update
 *
 */
@Component
public class NamePolicy implements IPolicyValidator {
    @Override
    public boolean supports(BitSet b) {
        return false;
    }

    @Override
    public boolean mode(String mode) {
        return true;
    }

    /**
     * Entry method to execute name enrolment and update related policies.
     * @param data
     * @return
     */
    @Override
    public Optional<ValidationError> validate(ExtractedPacket data) {
        return Optional.empty();
    }
}

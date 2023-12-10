package in.gov.cdc.cdcdemostage.validators.contact.policy;

import in.gov.cdc.cdcdemostage.models.ExtractedPacket;
import in.gov.cdc.cdcdemostage.models.ValidationError;
import in.gov.cdc.cdcdemostage.validators.specs.IPolicyValidator;
import org.springframework.stereotype.Component;

import java.util.BitSet;
import java.util.Optional;

/**
 * This class checks if any update request later to the current request has been already
 * processed. In that case, this request is to be rejected by the
 * Enrolment server.
 */
@Component
public class LaterUpdateMobileHandler implements IPolicyValidator {
    @Override
    public boolean supports(BitSet b) {
        return false;
    }

    @Override
    public String mode(String mode) {
        return "ONLINE";
    }

    /**
     * Entry method to check if any later requiest has already been processed
     * by the Enrolment Server.
     * @param data
     * @return
     */
    @Override
    public Optional<ValidationError> validate(ExtractedPacket data) {
        return Optional.empty();
    }
}

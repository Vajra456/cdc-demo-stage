package in.gov.cdc.cdcdemostage.validators.contact.policy;

import in.gov.cdc.cdcdemostage.models.ExtractedPacket;
import in.gov.cdc.cdcdemostage.models.ValidationError;
import in.gov.cdc.cdcdemostage.validators.specs.IPolicyValidator;
import org.springframework.stereotype.Component;

import java.util.BitSet;
import java.util.Optional;

/**
 * This class checks for the ownership of the mobile vis-a-vis the DoT database.
 * If the requestor is not the owner, then there should be a digital consent
 * from the owner to accept the request. Lack of the two would lead to rejection
 * of the request.
 */
@Component
public class MobileOwnershipPolicy implements IPolicyValidator {
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

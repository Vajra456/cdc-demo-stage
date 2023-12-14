package in.gov.cdc.cdcdemostage.validators.contact.policy;


import in.gov.cdc.cdcdemostage.models.ExtractedPacket;
import in.gov.cdc.cdcdemostage.models.ValidationError;
import in.gov.cdc.cdcdemostage.validators.specs.IPolicyValidator;
import org.springframework.stereotype.Component;

import java.util.BitSet;
import java.util.Optional;

/**
 * This class checks for the association of a mobile number with an UID. Number of
 * association should be below the business defined threshold for successful
 * processing of the request
 */
@Component
public class MobileAssociationPolicy implements IPolicyValidator {

    @Override
    public boolean supports(BitSet b) {
        return b.get(9);
    }

    @Override
    public boolean mode(String mode) {
        return true;
    }

    @Override
    public Optional<ValidationError> validate(ExtractedPacket enrollmentPacket) {
        //mobile-uid association validation code goes here
        return Optional.empty();
    }
}

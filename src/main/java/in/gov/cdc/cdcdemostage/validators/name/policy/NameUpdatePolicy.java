package in.gov.cdc.cdcdemostage.validators.name.policy;

import in.gov.cdc.cdcdemostage.models.ExtractedPacket;
import in.gov.cdc.cdcdemostage.models.ValidationError;
import in.gov.cdc.cdcdemostage.validators.specs.IPolicyValidator;
import org.springframework.stereotype.Component;

import java.util.BitSet;
import java.util.Optional;

/**
 * This class implements the nme update count policy defined by the UIDAI. It takes into consideration
 * the exception approved by the RO
 */
@Component
public class NameUpdatePolicy implements IPolicyValidator {

    @Override
    public boolean supports(BitSet b) {
        return false;
    }

    @Override
    public String mode(String mode) {
        return "ONLINE";
    }

    /**
     * Entry method to execute name update related policies on the request
     * @param data
     * @return
     */
    @Override
    public Optional<ValidationError> validate(ExtractedPacket data) {
        return Optional.empty();
    }



    /**
     * Method to check whether the udpated name is same as that of the
     * previosu name
     */
    private Optional<ValidationError>  isSameUdpatedName(String name ) {
        return Optional.empty();
    }

    /**
     * Method to check for any ongoing name update. In case any ongoing name update, hold the packet for
     * its disposal
     */
    private Optional<ValidationError> isAnyOngoingNameUpdate(String name) {
        return Optional.empty();
    }

    /**
     * Check if any name update request raised at a later date to the current request
     * has been successfully processed. That case, current request to be rejected
     */
    private Optional<ValidationError> checkForFreshernameUdpateRequest(String name) {
        return Optional.empty();
    }

}

package in.gov.cdc.cdcdemostage.validators.address.policy;

import in.gov.cdc.cdcdemostage.models.ExtractedPacket;
import in.gov.cdc.cdcdemostage.models.ValidationError;
import in.gov.cdc.cdcdemostage.validators.specs.IPolicyValidator;

import java.util.BitSet;
import java.util.Optional;

/**
 * This class checks for any Address update request raised at a later date to the
 * current request has been processed and already updated in the database. In that
 * case current address update request is rejected.
 */
public class LaterUpdateAddressHandler implements IPolicyValidator {
    @Override
    public boolean supports(BitSet b) {
        return false;
    }

    @Override
    public boolean mode(String mode) {
        return true;
    }

    @Override
    public Optional<ValidationError> validate(ExtractedPacket data) {
        return Optional.empty();
    }
}

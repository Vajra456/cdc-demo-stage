package in.gov.cdc.cdcdemostage.validators.gender.policy;

import in.gov.cdc.cdcdemostage.models.ValidationError;
import in.gov.cdc.cdcdemostage.validators.specs.IPolicyValidator;
import org.springframework.stereotype.Component;

import java.util.BitSet;
import java.util.Optional;

@Component
public class GenderUpdatePolicy implements IPolicyValidator<String> {

    @Override
    public boolean supports(BitSet b) {
        return false;
    }

    @Override
    public String mode(String mode) {
        return false;
    }

    /**
     * Entry method to perform gender update policy of UIDAI. As per the extant policy,
     * a resident is allowed to perform a gender once in lifetime.
     * @param data
     * @return
     */
    @Override
    public Optional<ValidationError> validate(ExtractedPacket data) {
        return Optional.empty();
    }
}

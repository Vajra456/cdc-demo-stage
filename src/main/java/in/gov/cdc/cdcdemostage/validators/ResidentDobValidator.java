package in.gov.cdc.cdcdemostage.validators;

import in.gov.cdc.cdcdemostage.models.UidV2Data;
import org.springframework.stereotype.Component;

import java.util.BitSet;
import java.util.Optional;

@Component
class ResidentDobValidator implements IValidator{
    @Override
    public boolean supports(BitSet b) {
        return b.get(3);
    }

    @Override
    public Optional<ValidationError> validate(UidV2Data[] uidV2Data) {
        return Optional.empty();
    }
}

package in.gov.cdc.cdcdemostage.validators;

import in.gov.cdc.cdcdemostage.models.UidV2Data;
import org.springframework.stereotype.Component;

import java.util.BitSet;
import java.util.Optional;

@Component
class ResidentLocalNameValidator implements IValidator{
    @Override
    public boolean supports(BitSet b) {
        return b.get(2);
    }

    @Override
    public Optional<ValidationError> validate(UidV2Data[] uidV2Data) {
        ValidationError ve = new ValidationError();
        ve.setErrorMessage("Local lang fonts aren't matching");
        return Optional.of(ve);
    }
}

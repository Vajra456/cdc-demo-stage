package in.gov.cdc.cdcdemostage.validators;

import in.gov.cdc.cdcdemostage.models.EventMessage;

import java.util.BitSet;
import java.util.List;
import java.util.stream.Collectors;

// This will be created as spring bean
public class DataValidator implements IDataValidator {

    // Constructor injection of all validators
    List<IValidator> validators;

    public DataValidator(List<IValidator> validators) {
        this.validators = validators;
    }

    // This will be only exposed method consumed by clients
    @Override
    public List<ValidationError> validate(EventMessage event) {

        BitSet bitSet = filter(event);
        return getSupportedValidators(bitSet).stream()
                .map(v -> v.validate(event.getUidV2DataArray()))
                .collect(Collectors.toList());
    }

    // Given an event message, return a bitset of the current change
    private BitSet filter(EventMessage event) {
        return null;
    }

    // Given a bitset get all the supported validators
    private List<IValidator> getSupportedValidators(BitSet bitSet){
        return this.validators.stream().filter(v -> v.supports(bitSet)).collect(Collectors.toList());
    }

}



package in.gov.cdc.cdcdemostage.validators;

import in.gov.cdc.cdcdemostage.models.EventMessage;
import org.springframework.stereotype.Component;

import java.util.BitSet;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class DataValidator implements IDataValidator {

    // Constructor injection of all validators
    List<IValidator> validators;

    public DataValidator(List<IValidator> validators) {
        this.validators = validators;
        this.validators.forEach(v -> System.out.println(v.getClass()));
    }

    // This will be only exposed method consumed by clients
    @Override
    public List<Optional<ValidationError>> validate(EventMessage event) {

        BitSet bitSet = filter(event);
        return getSupportedValidators(bitSet).stream()
                .map(v -> v.validate(event.getUidV2DataArray()))
                .collect(Collectors.toList());
    }

    // Given an event message, return a bitset of the current change
    private BitSet filter(EventMessage event) {
        BitSet bs = event.getUidV2DataArray()[0].getUidOriginTracker().getUpdateBits();
        bs.xor(event.getUidV2DataArray()[0].getUidOriginTracker().getRejectBits());
        System.out.println("bitset : " + bs);
        return bs;
    }

    // Given a bitset get all the supported validators
    private List<IValidator> getSupportedValidators(BitSet bitSet){
        return this.validators.stream().filter(v -> v.supports(bitSet)).collect(Collectors.toList());
    }

}



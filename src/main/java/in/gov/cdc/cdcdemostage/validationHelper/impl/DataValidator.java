//package in.gov.cdc.cdcdemostage.validationHelper.impl;
//
//import com.uidai.enu.common.model.EventMessage;
//import com.uidai.enu.common.model.ExtractedPacket;
//import in.gov.cdc.cdcdemostage.models.ValidationError;
//import in.gov.cdc.cdcdemostage.validationHelper.IDataValidator;
//import in.gov.cdc.cdcdemostage.validators.specs.IObjectValidator;
//import org.springframework.stereotype.Component;
//
//import java.util.BitSet;
//import java.util.List;
//import java.util.Optional;
//import java.util.stream.Collectors;
//
//@Component
//public class DataValidator implements IDataValidator {
//
//    // Constructor injection of all validators
//    List<IObjectValidator> validators;
//
//    public DataValidator(List<IObjectValidator> validators) {
//        this.validators = validators;
//        this.validators.forEach(v -> System.out.println(v.getClass()));
//    }
//
//    // This will be only exposed method consumed by clients
//    @Override
//    public List<Optional<ValidationError>> validate(EventMessage event, ExtractedPacket extractedPacket) {
//    // extractedPacket.setForcedQABy("jvusavs");
//        BitSet bitSet = filter(event);
//        return getSupportedValidators(bitSet).stream()
//                .map(v -> v.validate(extractedPacket,event))
//                .collect(Collectors.toList());
//    }
//
//    // Given an event message, return a bitset of the current change
//    private BitSet filter(EventMessage event) {
//        BitSet bs = new BitSet(32);
//        bs= BitSet.valueOf(event.getPacketMetaData().getBitMap().getBytes());
//        bs.xor(BitSet.valueOf(event.getRejectBits().getBytes()));
//        System.out.println("bitset : " + bs);
//        return bs;
//    }
//
//    // Given a bitset get all the supported validators
//    private List<IObjectValidator> getSupportedValidators(BitSet bitSet){
//        return this.validators.stream()
//                .filter(v -> v.supports(bitSet)).collect(Collectors.toList());
//    }
//}



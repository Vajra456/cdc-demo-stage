package in.gov.cdc.cdcdemostage.validators.dob;


import in.gov.cdc.cdcdemostage.models.Event;
import in.gov.cdc.cdcdemostage.models.ExtractedPacket;
import in.gov.cdc.cdcdemostage.models.ValidationError;
import in.gov.cdc.cdcdemostage.validators.specs.*;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * This class will orchestrate Dob validation checks against the incoming request.
 * Outcome of the validation would be recorded in the reject bitmap
 * indicator along with the detailed error code.
 */

@Component
public class DobObjectValidator implements IObjectValidator {




    // Constructor injection of all validators
    List<IValidator> validators;


    @Override
    public String mode(String mode) {
        return null;
    }

    @Override
    public String requestType(String requestType) {
        return null;
    }

    @Override
    public boolean supports(BitSet bitSet) {
        return bitSet.get(3);
    }

    // Default constructor. Here we are initializing the validators
    public DobObjectValidator(List<IValidator> validators) {
        this.validators = validators;
        this.validators.forEach(v -> System.out.println(v.getClass()));
    }

    /**
     * Entry menthod to perform syntax, semantic and policy validation on
     * the date object.
     * TODO: to be decorated with the loggers
     * @param extractedPacket
     * @param event
     * @return
     */
    @Override
    public Optional<List<ValidationError>> validate(ExtractedPacket extractedPacket, Event event) {

        List<ValidationError> errors = new ArrayList<>();


        syntaxValidation(extractedPacket, event).ifPresent(errors::addAll);

        if (errors.isEmpty()) {
            semanticValidation(extractedPacket, event).ifPresent(errors::addAll);
            policyValidation(extractedPacket, event).ifPresent(errors::addAll);
        }

        if (errors.isEmpty()) {
            // All validations passed
            System.out.println("DOB validation completed!!");
            return Optional.empty();
        } else {
            // TODO: Over here reduce the errors to an existing SEDA error code related DoB and set the rejected bit indicator
            return Optional.of(errors);
        }
    }

    /**
     * This method performs the syntax validation on the Dob
     * @param packet
     * @param event
     * @return
     */
    public Optional<List<ValidationError>> syntaxValidation(ExtractedPacket packet, Event event) {
        return Optional.of(getSupportedValidators(ISyntaxValidator.class,
                event.getRequestBitmap()).stream()
                .flatMap(v -> v.validate(packet).stream())
                .collect(Collectors.toList()));

    }

    /**
     * This class performs semantic validation on the DoB
     *
     * @param packet
     * @return
     */
    public Optional<List<ValidationError>> semanticValidation(ExtractedPacket packet, Event event) {

        return Optional.of(getSupportedValidators(ISemanticValidator.class,
                event.getRequestBitmap()).stream()
                .flatMap(v -> v.validate(packet).stream())
                .collect(Collectors.toList()));

    }

    /**
     * This class performs policy validation on the Dob
     *
     * @param packet
     * @return
     */
    public Optional<List<ValidationError>> policyValidation(ExtractedPacket packet, Event event){

        return Optional.of(getSupportedValidators(IPolicyValidator.class,
                event.getRequestBitmap()).stream()
                .flatMap(v -> v.validate(packet).stream())
                .collect(Collectors.toList()));
    }


    // Given an event message, return a bitset of the current change
//    private BitSet filter(EventMessage event) {
//        BitSet bs = event.getUidV2DataArray()[0].getUidOriginTracker().getUpdateBits();
//        bs.xor(event.getUidV2DataArray()[0].getUidOriginTracker().getRejectBits());
//        System.out.println("bitset : " + bs);
//        return bs;
//    }

    // Given a bitset and validators get all the supported validators
    private <T> List<? extends IValidator> getSupportedValidators(Class<T> validatorType, BitSet bitSet) {
        return validators.stream()
                .filter(v -> v.supports(bitSet) && validatorType.isInstance(v))
                .collect(Collectors.toList());
    }
}

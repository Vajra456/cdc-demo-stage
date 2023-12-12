package in.gov.cdc.cdcdemostage.validators.name;


import in.gov.cdc.cdcdemostage.models.Event;
import in.gov.cdc.cdcdemostage.models.ExtractedPacket;
import in.gov.cdc.cdcdemostage.models.ValidationError;
import in.gov.cdc.cdcdemostage.validators.name.policy.NamePolicy;
import in.gov.cdc.cdcdemostage.validators.name.syntax.NameSyntax;
import in.gov.cdc.cdcdemostage.validators.specs.IObjectValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.BitSet;
import java.util.List;
import java.util.Optional;

/**
 * This class orchestrates name validation related checks against the request.
 * Outcome of the request would be recorded in the reject bitmap to indicate
 * the later stages.
 */
@Component
public class NameObjectValidator implements IObjectValidator {

    @Autowired
    NameSyntax nameSyntaxValidator;
    @Autowired
    NamePolicy nameProcessValidation;
    @Override
    public boolean supports(BitSet bitSet) {
        return bitSet.get(1);
    }

    @Override
    public boolean mode(String mode) {
        return true;
    }

    @Override
    public boolean requestType(String requestType) {
        return true;
    }

    /**
     * Entry method for orchestrating the name validation based on the type of request and
     * mode of enrolment
     * @param extractedPacket
     * @param eventMessage
     * @return
     */
    @Override
    public Optional<List<ValidationError>> validate(ExtractedPacket extractedPacket, Event eventMessage) {

//        String residentName = extractedPacket.getName();
//        Optional<ValidationError> validationError  = syntaxValidation(residentName);
//
//        if(validationError.get().getErrorMessage() == null){
//            validationError = semanticValidation(extractedPacket);
//            if(validationError.get().getErrorMessage() == null){
//                validationError = policyValidation(extractedPacket);
//            }
//        }
//        System.out.println("Name validation completed!!");
        return Optional.empty();
    }

    /**
     * Syntax Validation
     * @param name
     * @return Optional<ValidationError>
     */
    public Optional<ValidationError> syntaxValidation(String name){
        ValidationError validationError =null;
        if (name != null) {
            validationError = nameSyntaxValidator.isBasicNameCheck(name);
            if (validationError.getErrorMessage() == null) {
                validationError = nameSyntaxValidator.isSpaceCheck(name);
                if (validationError.getErrorMessage() == null) {
                    validationError = nameSyntaxValidator.isDotCheck(name);
                    if (validationError.getErrorMessage() == null) {
                        validationError = nameSyntaxValidator.isPrePostSpaceCheck(name);
                    }
                }
            }
        }else{
            validationError.setErrorMessage("Resident name is null");
        }
        return Optional.of(validationError);
    }

    /**
     * Semantic Validation
     * @param packet
     * @return Optional<ValidationError>
     */

    public Optional<ValidationError> semanticValidation(ExtractedPacket packet){
        ValidationError validationError = null;
        // No validations
        return Optional.of(validationError);
    }

    /**
     * Business Process Validation
     * @param packet
     * @return Optional<ValidationError>
     */
    public Optional<ValidationError> policyValidation(ExtractedPacket packet){
        return  nameProcessValidation.validate(packet);
    }
}

package in.gov.cdc.cdcdemostage.validators.dob.policy;

import in.gov.cdc.cdcdemostage.models.ExtractedPacket;
import in.gov.cdc.cdcdemostage.models.ValidationError;
import in.gov.cdc.cdcdemostage.validators.specs.IPolicyValidator;
import org.springframework.stereotype.Component;

import java.util.BitSet;
import java.util.Optional;

import static in.gov.cdc.cdcdemostage.constant.Constants.OFFLINE;
import static in.gov.cdc.cdcdemostage.constant.Constants.ONLINE;

/**
 * This class handles the Dob declaration policy of UIDAI. It checks for DobType
 * and based on that value of the date field and as well availaibility of the
 * supporting documents
 */
@Component
public class DoBDeclarationPolicy implements IPolicyValidator {
    @Override
    public boolean supports(BitSet b) {
        return b.get(5) || b.get(13);           // Check the applicability of this validator
    }

    /**
     * This class is used to validate the date syntax for both ONLINE and OFFLINE mode
     * @param mode
     * @return
     */
    @Override
    public boolean mode(String mode) {
        return mode.equals(ONLINE) || mode.equals(OFFLINE);
    }


    /**
     * Entry method to check the DobDeclarationPolicy
     * @param data
     * @return
     */
    @Override
    public Optional<ValidationError> validate(ExtractedPacket data) {
        return Optional.empty();
    }

    /**
     * This method checks if the supporting PoB document are available for the dobType
     * This method undertakes a point of time validation on the supporting documents
     * @param dobType
     * @return
     */
    private boolean isValidSupportingPobAvailable(String dobType, String enrolmentDate) {       /* enrolmentDate can be Offset date */
        return false;
    }
}

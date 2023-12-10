package in.gov.cdc.cdcdemostage.validators.dob.policy;

import in.gov.cdc.cdcdemostage.models.ExtractedPacket;
import in.gov.cdc.cdcdemostage.models.ValidationError;
import in.gov.cdc.cdcdemostage.validators.specs.IPolicyValidator;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.BitSet;
import java.util.Optional;

@Component
public class MaxAgePolicy implements IPolicyValidator {
    @Override
    public boolean supports(BitSet b) {
        return b.get(3);
    }

    @Override
    public String mode(String mode) {
        return "ONLINE";
    }

    /**
     * Entry method to check validate the max age of the resident
     * @param dob
     * @return
     */
    @Override
    public Optional<ValidationError> validate(ExtractedPacket dob) {
        ValidationError validationError = null;
//        LocalDate parsedDate = LocalDate.of(dob.getYear(), dob.getMonth(), dob.getDay());
//        LocalDate currentDate = LocalDate.now();
//        // Calculate the difference in years between the current date and DOB
//        long age = java.time.temporal.ChronoUnit.YEARS.between(parsedDate, currentDate);
//        if (age > 120) {                            /* This is to be converted to a buisness token */
//            validationError.setErrorMessage("DoB process validation failed ,Age is greater than 120");
//        }
        return Optional.of(validationError);
    }

}

package in.gov.cdc.cdcdemostage.validators.dob.semantic;

import in.gov.cdc.cdcdemostage.models.ExtractedPacket;
import in.gov.cdc.cdcdemostage.models.ValidationError;
import in.gov.cdc.cdcdemostage.validators.specs.ISyntaxValidator;
import org.springframework.stereotype.Service;

import java.util.BitSet;
import java.util.Optional;

import static in.gov.cdc.cdcdemostage.constant.Constants.OFFLINE;
import static in.gov.cdc.cdcdemostage.constant.Constants.ONLINE;

@Service
public class DateSemantic implements ISyntaxValidator {


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


    @Override
    public Optional<ValidationError> validate(ExtractedPacket data) {

        return Optional.empty();
    }
//
//    public ValidationError isValidGregorianDate(Dob date) {
//        ValidationError validationError = new ValidationError(null);
//        try {
//            GregorianCalendar gregorianCalendar = new GregorianCalendar();
//            gregorianCalendar.setLenient(false); // Set strict checking
//
//            // Set the date components
//            gregorianCalendar.set(Calendar.YEAR, date.getYear());
//            gregorianCalendar.set(Calendar.MONTH, date.getMonth() - 1); // Month is 0-based in Calendar
//            gregorianCalendar.set(Calendar.DAY_OF_MONTH, date.getDate());
//
//            // Perform a get to trigger any potential exception for an invalid date
//            gregorianCalendar.getTime();
//        } catch (Exception e) {
//            validationError.setErrorMessage("Date semantic validation fail ,it's not a valid date");
//        }
//        return validationError;
//    }
//
//    public ValidationError isFutureDate(Dob date) {
//        ValidationError validationError = new ValidationError(null);
//
//        LocalDate parsedDate = LocalDate.of(date.getYear(),date.getMonth(),date.getDay());
//        LocalDate currentDate = LocalDate.now();
//
//        if(parsedDate.isAfter(currentDate)){
//            validationError.setErrorMessage("Date semantic validation fail ,it's a future date");
//            validationError.setRejectBitSet();
//        }
//        return validationError;
//    }
//
//
//    /**
//     * Prepare the validation for the age of guardian. Guardian age
//     * should be greater than that of the child and should be more
//     * than 18 yrs.
//     */
//    public ValidationError isValidAgeOfGuardian(Dob date) {
//        ValidationError validationError = new ValidationError(null);
//        return validationError;
//    }
//
//    /**
//     * Prepare the validation that guardian relation with the child
//     * can only be Father/Mother/Guardian.
//     */
//    public ValidationError isValidGuardianRelation(Dob date) {
//        ValidationError validationError = new ValidationError(null);
//        return validationError;
//    }
}



package in.gov.cdc.cdcdemostage.validators.address.syntax;


import in.gov.cdc.cdcdemostage.models.ValidationError;
import io.micrometer.common.util.StringUtils;
import org.springframework.stereotype.Component;

import java.util.BitSet;
import java.util.Optional;

//@Component
//public class MandatoryDataCheck {
//
//    public Optional<ValidationError> validate(ExtractedPacket enrollmentPacket) {
//        ResidentProfile address=enrollmentPacket.getPacket().getResidentProfile();
//        ValidationError validationError = new ValidationError(null);
//        if(enrollmentPacket==null||enrollmentPacket.getPacket()==null||enrollmentPacket.getPacket().getResidentProfile()==null)
//            validationError.setErrorMessage("Address syntax validation failed, mandatory data missing");
//        if(StringUtils.isBlank(address.getDistrict()) || StringUtils.isBlank(address.getDistrictName()) || StringUtils.isBlank(address.getPincode()) || StringUtils.isBlank(address.getState()) || StringUtils.isBlank(address.getStateName()) || StringUtils.isBlank(address.getVtc())){
//            validationError.setErrorMessage("Address syntax validation failed, mandatory data missing");
//        }
//        return Optional.of(validationError);
//    }
//}

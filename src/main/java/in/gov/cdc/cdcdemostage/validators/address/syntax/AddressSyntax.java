package in.gov.cdc.cdcdemostage.validators.address.syntax;

import in.gov.cdc.cdcdemostage.models.ExtractedPacket;
import in.gov.cdc.cdcdemostage.models.ValidationError;
import in.gov.cdc.cdcdemostage.validators.specs.ISyntaxValidator;
import io.micrometer.common.util.StringUtils;
import org.springframework.stereotype.Component;

import java.util.BitSet;
import java.util.Optional;
import java.util.regex.Pattern;

@Component
public class AddressSyntax implements ISyntaxValidator {

    public static final Pattern PINCODE_PATTERN = Pattern.compile("^\\d{6}$");
    public static final Pattern VTC_PATTERN = Pattern.compile("^.{8,50}$");
    public static final Pattern STATE_PATTERN = Pattern.compile("^.{1,50}$");
    public static final Pattern DISTRICT_PATTERN = Pattern.compile("^.{1,50}$");

    @Override
    public boolean supports(BitSet b) {
        return false;
    }

    @Override
    public String mode(String mode) {
        return null;
    }


    @Override
    public Optional<ValidationError> validate(ExtractedPacket enrollmentPacket) {
        return Optional.empty();
    }

//    public ValidationError isAddressBlank(ResidentProfile address) {
//        ValidationError validationError = new ValidationError(null);
//        StringBuffer addressText = new StringBuffer();
//        addressText.append(StringUtils.isNotBlank(address.getCareof()) ? address.getCareof() : "");
//        addressText.append(StringUtils.isNotBlank(address.getBuilding()) ? address.getBuilding() : "");
//        addressText.append(StringUtils.isNotBlank(address.getStreet()) ? address.getStreet() : "");
//        addressText.append(StringUtils.isNotBlank(address.getLandmark()) ? address.getLandmark() : "");
//        addressText.append(StringUtils.isNotBlank(address.getLocality()) ? address.getLocality() : "");
//        addressText.append(StringUtils.isNotBlank(address.getVtc()) ? address.getVtc() : "");
//        addressText.append(StringUtils.isNotBlank(address.getDistrict()) ? address.getDistrict() : "");
//        addressText.append(StringUtils.isNotBlank(address.getSubDistrict()) ? address.getSubDistrict() : "");
//        addressText.append(StringUtils.isNotBlank(address.getState()) ? address.getState() : "");
//        addressText.append(StringUtils.isNotBlank(address.getCountry()) ? address.getCountry() : "");
//        addressText.append(StringUtils.isNotBlank(address.getPincode()) ? address.getPincode() : "");
//
//        if (StringUtils.isBlank(addressText.toString())){
//            validationError.setErrorMessage("Address syntax validation failed, address is blank");
//        }
//        return validationError;
//    }

//    public ValidationError isMandatoryDataMissing(ResidentProfile address) {
//        ValidationError validationError = new ValidationError(null);
//        if(StringUtils.isBlank(address.getDistrict()) || StringUtils.isBlank(address.getDistrictName()) || StringUtils.isBlank(address.getPincode()) || StringUtils.isBlank(address.getState()) || StringUtils.isBlank(address.getStateName()) || StringUtils.isBlank(address.getVtc())){
//            validationError.setErrorMessage("Address syntax validation failed, mandatory data missing");
//        }
//        return validationError;
//    }





}

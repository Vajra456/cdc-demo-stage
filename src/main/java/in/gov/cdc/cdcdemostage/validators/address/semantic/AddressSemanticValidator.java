package in.gov.cdc.cdcdemostage.validators.address.semantic;

import in.gov.cdc.cdcdemostage.models.ExtractedPacket;
import in.gov.cdc.cdcdemostage.models.ValidationError;
import in.gov.cdc.cdcdemostage.validators.specs.ISemanticValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.BitSet;
import java.util.Optional;

@Component
@Slf4j
public class AddressSemanticValidator implements ISemanticValidator {

    @Override
    public boolean supports(BitSet b) {
        return b.get(15);
    }

    @Override
    public boolean mode(String mode) {
        return true;
    }

    @Override
    public Optional<ValidationError> validate(ExtractedPacket packet){
//        ValidationError validationError = new ValidationError(null);
//        List<StateInfo> stateInfo=null;
//        if(inputData==null||inputData.getData()==null||inputData.getData().getPincodeDetails()==null||inputData.getData().getPincodeDetails().getStateInfo()==null)
//            validationError.setErrorMessage("Address semantic validation failed, no state info available");
//        else
//            stateInfo= inputData.getData().getPincodeDetails().getStateInfo();
//        log.trace("Address mapping check started");
//        if (stateInfo != null) {
//            for (StateInfo state : stateInfo) {
//                validationError.setErrorMessage("Address semantic validation failed, State-pincode mapping fail");
//                if(!(state.getStateCodeOld().equals(residentProfile.getState())||state.getStateCodeNew().equals(residentProfile.getState())))
//                    continue;
//                List<DistrictInfo> districtInfo = state.getDistrictInfo();
//                if (districtInfo != null && districtInfo.size() > 0) {
//                    for (DistrictInfo districtInf : districtInfo) {
//                        validationError.setErrorMessage("Address semantic validation failed, District-pincode mapping fail");
//                        if(!(districtInf.getDistrictCodeOld().equals(residentProfile.getDistrict())||districtInf.getDistrictCodeNew().equals(residentProfile.getDistrict())))
//                            continue;
//
//                        List<SubDistrictInfo> subdistrictInfo = districtInf.getSubDistrictInfo();
//
//                        if (null != subdistrictInfo && subdistrictInfo.size() > 0) {
//
//                            for (SubDistrictInfo subInfo : subdistrictInfo) {
//
//                                List<VillageInfo> lstvillageInfo = subInfo.getVillageInfo();
//
//                                if (null != lstvillageInfo && lstvillageInfo.size() > 0) {
//
//                                    for (VillageInfo villageInfo : lstvillageInfo) {
//                                        validationError.setErrorMessage("Address semantic validation failed, Village-pincode mapping fail");
//                                        if(!(villageInfo.getVillageCodeOld().equals(residentProfile.getVtc())||villageInfo.getVillageCodeNew().equals(residentProfile.getVtc())))
//                                            continue;
//
//                                        if (null != villageInfo && villageInfo.getVillageCodeOld().equals(residentProfile.getVtc())) {
//
//                                            for(PostOfficeInfo postOffice : villageInfo.getPostofficeInfo()) {
//                                                validationError.setErrorMessage("Address semantic validation failed, Post office-pincode mapping fail");
//
//                                                if (null!=postOffice && postOffice.getPincode().equals(residentProfile.getPincode())
//                                                        && postOffice.getPostOfficeName().equalsIgnoreCase(residentProfile.getPoName())) {
//                                                    log.trace("Matching address mapping");
//                                                    return Optional.of(new ValidationError(null));
//                                                }
//                                            }
//                                        }
//
//                                    }// village loop
//                                }
//                            }// Address Sub district loop
//                        }
//                    }//district loop
//                }
//            }//State loop
//        }

        return Optional.empty();

    }




}

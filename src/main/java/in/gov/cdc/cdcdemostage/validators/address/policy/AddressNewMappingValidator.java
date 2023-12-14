//package in.gov.cdc.cdcdemostage.validators.address.process;
//
//import com.uidai.enu.common.model.ResidentProfile;
//import in.gov.cdc.cdcdemostage.models.pincode.*;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.stereotype.Component;
//
//import java.util.List;
//
//@Component
//@Slf4j
//public class AddressNewMappingValidator {
//
//    public boolean validate(List<StateInfo> stateInfo, ResidentProfile residentProfile){
//        log.trace("Address mapping check started");
//        if (stateInfo != null) {
//            for (StateInfo state : stateInfo) {
//                if(!(state.getStateCodeOld().equals(residentProfile.getState())||state.getStateCodeNew().equals(residentProfile.getState())))
//                    continue;
//                List<DistrictInfo> districtInfo = state.getDistrictInfo();
//                if (districtInfo != null && districtInfo.size() > 0) {
//                    for (DistrictInfo districtInf : districtInfo) {
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
//                                        if(!(villageInfo.getVillageCodeOld().equals(residentProfile.getVtc())||villageInfo.getVillageCodeNew().equals(residentProfile.getVtc())))
//                                            continue;
//
//                                        if (null != villageInfo && villageInfo.getVillageCodeOld().equals(residentProfile.getVtc())) {
//
//                                            for(PostOfficeInfo postOffice : villageInfo.getPostofficeInfo()) {
//
//
//                                                if (null!=postOffice && postOffice.getPincode().equals(residentProfile.getPincode())
//                                                        && postOffice.getPostOfficeName().equalsIgnoreCase(residentProfile.getPoName())) {
//                                                    log.trace("Matching address mapping");
//                                                    return true;
//                                                }
//                                            }
//                                        }
//                                    }// village loop
//                                }
//                            }// Address Sub district loop
//                        }
//                    }//district loop
//                }
//            }//State loop
//        }
//        return false;
//
//    }
//}

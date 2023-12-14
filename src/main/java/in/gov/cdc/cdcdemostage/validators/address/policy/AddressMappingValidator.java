//package in.gov.cdc.cdcdemostage.validators.address.process;
//
//import com.uidai.enu.common.model.ResidentProfile;
//import in.gov.cdc.cdcdemostage.models.pincode.*;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import java.util.List;
//@Slf4j
//
//@Component
//public class AddressMappingValidator {
//    @Autowired
//    AddressNewMappingValidator addressNewMappingValidator;
//    public boolean validateStateDistrictAndSubDistrict(List<StateInfo> stateInfo, String villageCode, String stateDistrictSubDistrictCode, String geoType) {
//
//        boolean isValid=false;
//
//            if (null != stateDistrictSubDistrictCode) {
//
//                if (stateInfo != null) {
//
//                    for (StateInfo state : stateInfo) {
//
//                        List<DistrictInfo> districtInfo = state.getDistrictInfo();
//
//                        if (districtInfo != null && districtInfo.size() > 0) {
//                            for (DistrictInfo district : districtInfo) {
//
//                                List<SubDistrictInfo> subdistricInfo = district.getSubDistrictInfo();
//                                if (subdistricInfo != null && subdistricInfo.size() > 0) {
//                                    for (SubDistrictInfo sudistrict : subdistricInfo) {
//
//                                        if (null != sudistrict && null != sudistrict.getVillageInfo()
//                                                && sudistrict.getVillageInfo().size() > 0) {
//                                            for (VillageInfo village : sudistrict.getVillageInfo()) {
//                                                String code = null;
//                                                if(GeoType.State.name().equals(geoType)) {
//                                                    code = state.getStateCodeOld();
//                                                }else if(GeoType.District.name().equals(geoType)) {
//                                                    code = district.getDistrictCodeOld();
//                                                }
//                                                if (null!=code && code.equals(stateDistrictSubDistrictCode)
//                                                        && null!=village.getVillageCodeOld() && village.getVillageCodeOld().equals(villageCode)) {
//
//                                                    isValid = true;
//                                                    log.trace("Matching Code " + code + "Matching Village Old Code "
//                                                            + village.getVillageCodeOld());
//                                                    break;
//                                                }
//
//                                            }
//                                        }
//                                        if (isValid) break; // Subdistrict loop
//                                    }
//                                }
//                                if (isValid) break; // District loop
//                            }
//                        }
//                        if (isValid) break; // State loop
//                    }
//                }
//            }
//
//        log.debug("End validateStateDistrictAndSubDistrict() method");
//        return isValid;
//
//    }
//    public boolean poNameValidation(List<StateInfo> stateInfo, String Pincode, String vtc,String poName) {
//        boolean isValid=false;
//            if (stateInfo != null) {
//                for (StateInfo state : stateInfo) {
//                    List<DistrictInfo> districtInfo = state.getDistrictInfo();
//                    if (districtInfo != null && districtInfo.size() > 0) {
//                        for (DistrictInfo districtInf : districtInfo) {
//
//                            List<SubDistrictInfo> subdistrictInfo = districtInf.getSubDistrictInfo();
//
//                            if (null != subdistrictInfo && subdistrictInfo.size() > 0) {
//
//                                for (SubDistrictInfo subInfo : subdistrictInfo) {
//
//                                    List<VillageInfo> lstvillageInfo = subInfo.getVillageInfo();
//
//                                    if (null != lstvillageInfo && lstvillageInfo.size() > 0) {
//
//                                        for (VillageInfo villageInfo : lstvillageInfo) {
//
//                                            if (null != villageInfo && villageInfo.getVillageCodeOld().equals(vtc)) {
//
//                                                for(PostOfficeInfo postOffice : villageInfo.getPostofficeInfo()) {
//
//
//                                                    if (null!=postOffice && postOffice.getPincode().equals(Pincode)
//                                                            && postOffice.getPostOfficeName().equalsIgnoreCase(poName)) {
//
//                                                        isValid = true;
//                                                        log.trace("Matching Pin Code" + Pincode
//                                                                + "Matching PostOfficeName " + poName);
//                                                        break;
//                                                    }
//                                                }
//                                            }
//                                        }
//                                    }if (isValid) break; // Address Sub district loop
//                                }
//                            }if(isValid) break; //district loop
//                        }
//                    }if(isValid) break; //State loop
//                }
//            }
//        log.debug("End poNameValidation() method");
//        return isValid;
//    }
//    public boolean validateVillageMappingWithPincode(List<StateInfo> stateInfo, String villageCode) {
//
//        log.info("Start validateVillageMappingWithPincode() method Village Code " +villageCode);
//        Boolean isValid = false;
//
//                if (stateInfo != null) {
//
//                    for (StateInfo state : stateInfo) {
//                        List<DistrictInfo> districtInfo = state.getDistrictInfo();
//                        if (districtInfo != null && districtInfo.size() > 0) {
//                            for (DistrictInfo district : districtInfo) {
//
//                                List<SubDistrictInfo> subdistricInfo = district.getSubDistrictInfo();
//
//                                if (subdistricInfo != null && subdistricInfo.size() > 0) {
//                                    for (SubDistrictInfo subdistrict : subdistricInfo) {
//
//                                        if (null != subdistrict && null != subdistrict.getVillageInfo()
//                                                && subdistrict.getVillageInfo().size() > 0) {
//                                            for (VillageInfo village : subdistrict.getVillageInfo()) {
//
//                                                if (null != village.getVillageCodeOld()
//                                                        && village.getVillageCodeOld().equals(villageCode)) {
//
//                                                    isValid = true;
//                                                    log.trace("Pin Code Matched with " + villageCode
//                                                            + "System Village Old Code " + village.getVillageCodeOld());
//                                                    break;
//                                                }
//
//                                            }
//                                        }
//                                        if (isValid) break; // sub district loop
//                                    }
//                                }
//                                if (isValid) break; // district loop
//                            }
//                        }if (isValid) break; // sub district loop
//                    }
//                }
//        log.debug("End validateVillageMappingWithPincode() method");
//        return isValid;
//
//    }
//
//    boolean validate(MasterDataResponse inputData, ResidentProfile residentProfile){
//        List<StateInfo> stateInfo=null;
//        if(inputData==null||inputData.getData()==null||inputData.getData().getPincodeDetails()==null||inputData.getData().getPincodeDetails().getStateInfo()==null)
//            return false;
//        else
//            stateInfo= inputData.getData().getPincodeDetails().getStateInfo();
//        boolean valid= addressNewMappingValidator.validate(stateInfo,residentProfile);
////        if(validateVillageMappingWithPincode(stateInfo,residentProfile.getVtc()))
////            log.debug("village mapped with pincode");
////        else {
////            log.debug("village unmached with pincode");
////            return false;
////        }
////        if(validateStateDistrictAndSubDistrict(stateInfo,
////                residentProfile.getVtc(), residentProfile.getDistrict(), GeoType.District.name())&&validateStateDistrictAndSubDistrict(stateInfo,
////                    residentProfile.getVtc(), residentProfile.getState(), GeoType.State.name())&&poNameValidation(stateInfo, residentProfile.getPincode(),
////                residentProfile.getVtc(), residentProfile.getPoName()))
////            log.debug("secuess mapped everything");
////        else{
////            log.debug("mappiing not found");
////            return false;
////        }
//        return true;
//    }
//
//
//}

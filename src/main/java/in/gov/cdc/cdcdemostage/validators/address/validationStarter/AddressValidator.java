//package in.gov.cdc.cdcdemostage.validators.address.validationStarter;
//
//import com.uidai.enu.common.model.EventMessage;
//import com.uidai.enu.common.model.ExtractedPacket;
//import com.uidai.enu.common.model.ResidentProfile;
//import in.gov.cdc.cdcdemostage.feignClient.MasterDataApiHandler;
//import in.gov.cdc.cdcdemostage.feignClient.TestTokenGenerator;
//import in.gov.cdc.cdcdemostage.models.Query;
//import in.gov.cdc.cdcdemostage.models.ValidationError;
//import in.gov.cdc.cdcdemostage.models.auth;
//import in.gov.cdc.cdcdemostage.models.pincode.MasterDataResponse;
//import in.gov.cdc.cdcdemostage.validators.specs.IObjectValidator;
//import in.gov.cdc.cdcdemostage.validators.address.syntax.MandatoryDataCheck;
//import in.gov.cdc.cdcdemostage.validators.address.validationInterfaces.ISemanticAddressValidator;
//import in.gov.cdc.cdcdemostage.validators.address.validationInterfaces.ISyntaxAddressValidator;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Component;
//
//import java.util.BitSet;
//import java.util.List;
//import java.util.Optional;
//import java.util.stream.Collectors;
//
//@Component
//public class AddressObjectValidator implements IObjectValidator {
//
//    List<ISyntaxAddressValidator> iSyntaxAddressValidators;
//
//    List<ISemanticAddressValidator> iSemanticAddressValidators;
//
//    public AddressObjectValidator(List<ISyntaxAddressValidator> iSyntaxAddressValidators,List<ISemanticAddressValidator> iSemanticAddressValidators){
//        this.iSyntaxAddressValidators=iSyntaxAddressValidators;
//        this.iSemanticAddressValidators=iSemanticAddressValidators;
//    }
//
//    @Autowired
//    TestTokenGenerator testTokenGenerator;
//
//    @Autowired
//    MasterDataApiHandler masterDataApiHandler;
//    @Autowired
//    MandatoryDataCheck mandatoryDataCheck;
//
//    @Override
//    public boolean supports(BitSet bitSet) {
//        //TODO local address bitset.get(16) is to be handled
//        return bitSet.get(15);
//    }
//
//    @Override
//    public Optional<ValidationError> validate(ExtractedPacket extractedPacket, EventMessage event) {
//        ResidentProfile residentProfile = extractedPacket.getPacket().getResidentProfile();
//        Optional<ValidationError> validationError = mandatoryDataCheck.validate(extractedPacket);
//        if(validationError.get().getErrorMessage()!=null){
//            return validationError;
//        }
//        BitSet bs = new BitSet(32);
//        bs= BitSet.valueOf(event.getPacketMetaData().getBitMap().getBytes());
//        bs.xor(BitSet.valueOf(event.getRejectBits().getBytes()));
//        BitSet finalBs = bs;
//        Optional<ValidationError> syntaxVal=this.syntaxValidation(extractedPacket,event,finalBs);
//        Optional<ValidationError> semanticVal=this.semanticValidation(extractedPacket,event,finalBs);
//        System.out.println("Address validation completed!!");
//        return validationError;
//    }
//
//
//    /**
//     * Syntax Validation
//     * @param extractedPacket
//     * @param event
//     * @return Optional<ValidationError>
//     */
//    public Optional<ValidationError> syntaxValidation(ExtractedPacket extractedPacket,EventMessage event,BitSet finalBs){
//        ValidationError validationError=new ValidationError(null);
//        List<ISyntaxAddressValidator> validators= iSyntaxAddressValidators.stream().filter(v -> v.supports(finalBs)).collect(Collectors.toList());
//        List<Optional<ValidationError>> errors = validators.stream().map(v -> v.validate(extractedPacket)).collect(Collectors.toList());
//        return Optional.of(validationError);
//    }
//
//    /**
//     * Semantic Validation
//     * @param extractedPacket
//     * @param eventMessage
//     * @param finalBs
//     * @return Optional<ValidationError>
//     */
//    public Optional<ValidationError> semanticValidation(ExtractedPacket extractedPacket,EventMessage eventMessage,BitSet finalBs){
//        ValidationError validationError=new ValidationError(null);
//        ResidentProfile residentProfile=extractedPacket.getPacket().getResidentProfile();
//        String opUid="999957879496";
//        ResponseEntity<auth> value =testTokenGenerator.getData(opUid);
//        String token=value.getBody().getAccess_token();
//        String pincode=residentProfile.getPincode();
//        String requestid="a9eb46c4-4df9-4619-9c1b-f81b54e66a5d";
//
//        String content="application/json";
//        String beertoken="Bearer "+token;
//        Query query = new Query("query PincodeDetails { pincodeDetails(pincode: \""+pincode+"\") { stateInfo { districtInfo { subDistrictInfo { villageInfo { villageName postofficeInfo { pincode postOfficeCode postOfficeName postOfficeNameLocal postOfficeType } villageCodeNew villageCodeOld villageNameLocal } subDistrictNameLocal subDistrictName subDistrictCodeOld subDistrictCodeNew } districtCodeNew districtCodeOld districtName districtNameLocal } stateCodeNew stateCodeOld stateName stateNameLocal } }}");
//        ResponseEntity<MasterDataResponse> pincodeDetailResponseEntity = masterDataApiHandler.executeQuery(query,requestid,content,beertoken);
//        MasterDataResponse masterDataResponse=null;
//        if(pincodeDetailResponseEntity.getBody()!=null)
//            masterDataResponse=pincodeDetailResponseEntity.getBody();
//        MasterDataResponse inputdata=masterDataResponse;
//        List<ISemanticAddressValidator> validators= iSemanticAddressValidators.stream().filter(v -> v.supports(finalBs)).collect(Collectors.toList());
//        List<Optional<ValidationError>> errors = validators.stream().map(v -> v.validate(inputdata,residentProfile)).collect(Collectors.toList());
////        ValidationError validationError  = addressSemanticValidator.validateAddressMapping(pincodeDetailResponseEntity.getBody(),residentProfile);
//        return Optional.of(validationError);
//    }
//
//    /**
//     * Business Process Validation
//     * @param residentProfile
//     * @return Optional<ValidationError>
//     */
//    public Optional<ValidationError> businessProcessValidation(ResidentProfile residentProfile){
//        ValidationError validationError = new ValidationError(null);
//        return Optional.of(validationError);
//    }
//
//}

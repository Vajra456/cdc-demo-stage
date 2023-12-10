package in.gov.cdc.cdcdemostage.feignClient;

import in.gov.cdc.cdcdemostage.models.Query;
import in.gov.cdc.cdcdemostage.models.QueryForDocument;
import in.gov.cdc.cdcdemostage.models.document.MasterDataResponseForProofOfDetails;
import in.gov.cdc.cdcdemostage.models.pincode.MasterDataResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import static in.gov.cdc.cdcdemostage.constant.Constants.*;

@FeignClient(name="masterDataApi" ,url = "http://10.10.230.101:31816/mda/", configuration = FeignConfig.class)
public interface MasterDataApiHandler {
    @PostMapping(value = "/graphql", consumes = "application/json")
    ResponseEntity<MasterDataResponse> executeQuery(@RequestBody Query query,
                                    @RequestHeader(X_Request_Id) String requestId ,
                                    @RequestHeader(CONTENT_TYPE) String contenttype,
                                    @RequestHeader(BEARER_TOKEN_KEY) String authcode);

    @PostMapping(value = "/graphql", consumes = "application/json")
    ResponseEntity<MasterDataResponseForProofOfDetails> executeQuery(@RequestBody QueryForDocument query,
                                                                     @RequestHeader(X_Request_Id) String requestId ,
                                                                     @RequestHeader(CONTENT_TYPE) String contenttype,
                                                                     @RequestHeader(BEARER_TOKEN_KEY) String authcode);
}

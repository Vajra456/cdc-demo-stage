package in.gov.cdc.cdcdemostage.feignClient;

import in.gov.cdc.cdcdemostage.models.auth;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name="tokenGeneratingApi" ,url = "http://10.10.230.101:32479/access")
public interface TestTokenGenerator {
    @GetMapping("/generateTestToken")
    ResponseEntity<auth> getData(@RequestParam String opUid);
}

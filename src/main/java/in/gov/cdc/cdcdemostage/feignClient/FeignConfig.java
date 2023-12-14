package in.gov.cdc.cdcdemostage.feignClient;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfig {
    @Bean
    public ObjectMapper objectMapper(){
        return new ObjectMapper();
    }

}

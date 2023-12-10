package in.gov.cdc.cdcdemostage.validators.document;

import com.fasterxml.jackson.databind.ObjectMapper;
import in.gov.cdc.cdcdemostage.feignClient.MasterDataApiHandler;
import in.gov.cdc.cdcdemostage.feignClient.TestTokenGenerator;
import in.gov.cdc.cdcdemostage.models.ExtractedPacket;
import in.gov.cdc.cdcdemostage.models.QueryForDocument;
import in.gov.cdc.cdcdemostage.models.ValidationError;
import in.gov.cdc.cdcdemostage.models.auth;
import in.gov.cdc.cdcdemostage.models.document.MasterDataResponseForProofOfDetails;
import in.gov.cdc.cdcdemostage.validators.specs.ISyntaxValidator;
import in.gov.cdc.cdcdemostage.validators.address.syntax.AddressSyntax;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.BitSet;
import java.util.Optional;

@Component
public class DocumentValidator implements ISyntaxValidator {
    @Autowired
    AddressSyntax addressSyntaxValidator;

    @Autowired
    TestTokenGenerator testTokenGenerator;

    @Autowired
    MasterDataApiHandler masterDataApiHandler;
    @Autowired
    ObjectMapper objectMapper;

    @Override
    public boolean supports(BitSet bitSet) {
        //TODO local address bitset.get(16) is to be handled
        return bitSet.get(15);
    }

    @Override
    public String mode(String mode) {
        return "ONLINE";
    }

    /**
     * Entry method to undertake name syntax validation
     * This method to record its outcome in a cache to self correct the name
     * while writing to the UIDv2Master
     * @param name
     * @return
     */
    @Override
    public Optional<ValidationError> validate(ExtractedPacket name) {
        ValidationError result = null;
        return Optional.empty();
    }
}

package in.gov.cdc.cdcdemostage.validators;

import in.gov.cdc.cdcdemostage.annotations.RuleDescriptor;
import in.gov.cdc.cdcdemostage.model.User;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Slf4j
@RuleDescriptor(mask = "11100010101010000001010101010101",requestType = "U")
public class DocumentValidator  {
    private static final long DEFAULT_MAX_FILE_SIZE = 5 * 1024L * 1024;

    @Value("${aap.apricot.document.allowedContentTypes:}#{T(java.util.Collections).emptyList()}")
    private List<String> allowedContentTypes;

    @Value("${aap.apricot.document.allowedFileNames:}#{T(java.util.Collections).emptyList()}")
    private List<String> allowedFileNames;

    @Value("${aap.apricot.document.max.size:" + DEFAULT_MAX_FILE_SIZE + "}")
    private long maxFileSize;

    @RuleDescriptor(mask = "11100010101010000001010101010101",requestType = "U")
    public @NotNull Map<String, Serializable> validate(User user) {

        Map<String, Serializable> errors = new HashMap<>();
        
        return errors;
    }
}

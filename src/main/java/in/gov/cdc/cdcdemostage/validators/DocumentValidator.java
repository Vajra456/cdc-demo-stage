package in.gov.cdc.cdcdemostage.validators;

import in.gov.cdc.cdcdemostage.model.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class DocumentValidator implements Validator<User, Serializable> {
    private static final long DEFAULT_MAX_FILE_SIZE = 5 * 1024L * 1024;

    @Value("${aap.apricot.document.allowedContentTypes:}#{T(java.util.Collections).emptyList()}")
    private List<String> allowedContentTypes;

    @Value("${aap.apricot.document.allowedFileNames:}#{T(java.util.Collections).emptyList()}")
    private List<String> allowedFileNames;

    @Value("${aap.apricot.document.max.size:" + DEFAULT_MAX_FILE_SIZE + "}")
    private long maxFileSize;

    @Override
    public Map<String, Serializable> validate(User user) {

        Map<String, Serializable> errors = new HashMap<>();
        
        return errors;
    }
}

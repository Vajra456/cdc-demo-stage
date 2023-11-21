package in.gov.cdc.cdcdemostage.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class ExecutionSummary implements Serializable {
    private static final long serialVersionUID = 1L;

    @JsonProperty(value="isExecutionSuccess")
    private boolean isExecutionSuccess;
    private boolean hasExecutionErrors;
    @JsonProperty(value="isValidationSuccess")
    private boolean isValidationSuccess;
    private boolean hasValidationErrors;
    private String packetStatus;
    private ErrorData errorData;
}

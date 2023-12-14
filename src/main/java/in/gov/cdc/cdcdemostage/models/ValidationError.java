package in.gov.cdc.cdcdemostage.models;

import lombok.AllArgsConstructor;

import java.util.BitSet;
import java.util.Optional;

@AllArgsConstructor
public class ValidationError {

    BitSet rejectBitSet = new BitSet(32);

    private String errorMessage;

    public String getErrorMessage() {
        return errorMessage;
    }

    public BitSet getBitSet() { return  rejectBitSet; }

    public void setErrorMessage( String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public void setRejectBitSet(BitSet rejectBitSet) {
        this.rejectBitSet = rejectBitSet;
    }


}

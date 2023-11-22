package in.gov.cdc.cdcdemostage.models;

import java.util.BitSet;

public class UidOriginTracker {

    private BitSet updateBits;
    private BitSet rejectBits;

    public BitSet getUpdateBits() {
        return updateBits;
    }

    public void setUpdateBits(BitSet updateBits) {
        this.updateBits = updateBits;
    }

    public BitSet getRejectBits() {
        return rejectBits;
    }

    public void setRejectBits(BitSet rejectBits) {
        this.rejectBits = rejectBits;
    }
}

package in.gov.cdc.cdcdemostage.models;

import java.io.Serializable;
import java.util.List;

public class PacketMetaData implements Serializable {
    private static final long serialVersionUID = 1L;

    private String refId;
    private String enrolmentType;
    private String srn;
    private String uid;
    private String bitMap;
    private String toa;
    private int priority;
    private String stageExemptionList;
    private List<Validation> excludeValidationNames;

}

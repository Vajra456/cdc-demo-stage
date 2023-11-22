package in.gov.cdc.cdcdemostage.models;

import java.io.Serializable;

public class EventMessage implements Serializable {
    private static final long serialVersionUID = 1L;

    private String eventId;
    private String category;
    private String eventType;
    private String eventTimestamp;//String of Date
    private String sid;
    private String sidDate;//String of Date
    private String version;
    private String sourceTopic;
    private String callbackTopic;
    private FlowMetaData flowMetaData;
    private PacketMetaData packetMetaData;
    private ExecutionSummary packetExecutionSummary;
    private String rejectBits;
    private String requestStage;
    private String requestStageStatus;
    private UidV2Data[] uidV2DataArray; // [originTracker, uidMaster, uidPhoto, uidAddress, uidResPref]

    public UidV2Data[] getUidV2DataArray() {
        return uidV2DataArray;
    }

    public void setUidV2DataArray(UidV2Data[] uidV2DataArray) {
        this.uidV2DataArray = uidV2DataArray;
    }
}



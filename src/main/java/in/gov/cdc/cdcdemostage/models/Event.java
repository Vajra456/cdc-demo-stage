package in.gov.cdc.cdcdemostage.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.BitSet;

@Getter
@Setter
@AllArgsConstructor
public class Event {

    String refId;

    String eventId;

    String mode;

    String requestType;

    BitSet requestBitmap;

    BitSet rejectBitmap;



}

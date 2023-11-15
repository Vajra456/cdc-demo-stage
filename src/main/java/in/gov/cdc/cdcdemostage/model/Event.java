package in.gov.cdc.cdcdemostage.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * This class simulates an event for testing of the application.
 */

@Getter
@Setter
@AllArgsConstructor
public class Event {

    String refId;
    String eid;
    String requestType;
    String bitmap;
    String arrivalTime;
    int priority;

}

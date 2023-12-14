package in.gov.cdc.cdcdemostage.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
public class ExtractedPacket {

    String name;

    String gender;

    Address address;

    Date dob;

    String email;

    String mobileNumber;
}

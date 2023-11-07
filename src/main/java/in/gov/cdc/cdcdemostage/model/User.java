package in.gov.cdc.cdcdemostage.model;

import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;

@Getter
@Setter
public class User {

    private String name;
    private String password;
    private String email;
    private OffsetDateTime dob;

}

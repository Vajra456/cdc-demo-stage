package in.gov.cdc.cdcdemostage.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.OffsetDateTime;

@Getter
@Setter
@AllArgsConstructor
public class User implements Serializable {

    private String name;
    private String password;
    private String email;
    private OffsetDateTime dob;

}

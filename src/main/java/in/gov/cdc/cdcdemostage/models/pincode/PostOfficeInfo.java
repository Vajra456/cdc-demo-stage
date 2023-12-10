package in.gov.cdc.cdcdemostage.models.pincode;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PostOfficeInfo implements Serializable{
    String pincode;

    String postOfficeName;

    String postOfficeCode;

    String postOfficeNameLocal;


    String postOfficeType;
}

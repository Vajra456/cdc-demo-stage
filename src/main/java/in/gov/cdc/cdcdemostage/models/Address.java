package in.gov.cdc.cdcdemostage.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Address {

    String landmark;

    String address1;

    String address2;

    String address3;

    String state;

    String district;

    String subDistrict;

    String vtc;

    String pinCode;

}

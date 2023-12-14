package in.gov.cdc.cdcdemostage.models.pincode;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Data implements Serializable {
    PincodeDetail pincodeDetails;

}

package in.gov.cdc.cdcdemostage.models.pincode;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PincodeDetail implements Serializable {

    List<StateInfo> stateInfo;
}

package in.gov.cdc.cdcdemostage.models.pincode;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StateInfo implements Serializable{

    String stateName;

    String stateCodeOld;

    String stateCodeNew;
    String stateNameLocal;

    List<DistrictInfo> districtInfo;
}

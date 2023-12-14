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
public class SubDistrictInfo implements Serializable{

    String subDistrictName;
    String subDistrictCodeOld;
    String subDistrictCodeNew;
    String subDistrictNameLocal;
    List<VillageInfo> villageInfo;
}

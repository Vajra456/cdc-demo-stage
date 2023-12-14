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
public class DistrictInfo implements Serializable{
    String districtName;

    String districtCodeOld;

    String districtCodeNew;

    String districtNameLocal;

    List<SubDistrictInfo> subDistrictInfo;
}

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
public class VillageInfo implements Serializable{

    String villageName;

    String villageCodeOld;

    String villageCodeNew;

    String villageNameLocal;

    List<PostOfficeInfo> postofficeInfo;
}

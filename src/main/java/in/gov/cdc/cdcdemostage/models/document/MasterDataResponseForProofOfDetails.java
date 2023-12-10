package in.gov.cdc.cdcdemostage.models.document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MasterDataResponseForProofOfDetails implements Serializable {
    private DataOfDocument data;
}

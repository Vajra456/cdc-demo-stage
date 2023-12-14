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
public class ProofDetails implements Serializable {
    private String documentId;
    private String documentImage;
    private String documentName;
    private String documentDescription;
    private int numOfPages;
}

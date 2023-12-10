package in.gov.cdc.cdcdemostage.models.document;

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
public class DataOfDocument implements Serializable {
    private List<ProofDetails> proofDetails;
}

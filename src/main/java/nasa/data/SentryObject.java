package nasa.data;

import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@ToString
public class SentryObject {
    private String count;
    private SentrySignatureObject signature;
    private List<SentryDataObject> data;

    public SentrySignatureObject getSignature() {
        return signature;
    }
//public  SentryObject(SentrySignatureObject signature){
//    this.signature =  signature;
//
//}

}


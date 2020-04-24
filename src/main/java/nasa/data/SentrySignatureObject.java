package nasa.data;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class SentrySignatureObject {
    private String source;
    private String version;

    public SentrySignatureObject(){}
    public SentrySignatureObject(String source){}

    public String getSource() {
        return source;
    }
}

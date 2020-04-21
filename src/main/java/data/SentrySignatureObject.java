package data;

import lombok.Getter;

@Getter
public class SentrySignatureObject {
    private String source;
    private String version;

    @Override
    public String toString() {
        return "SentrySignatureObject{" +
                "source='" + source + '\'' +
                ", version='" + version + '\'' +
                '}';
    }
}

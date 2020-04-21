package data;

import lombok.Getter;

import java.util.List;

@Getter
public class SentryObject {
    private String count;
    private SentrySignatureObject signature;
    private List<SentryDataObject> data;

    @Override
    public String toString(){
        return "SentryObject{" +
                "count='" + count + '\'' +
                ", signature='" + signature + '\'' +
                ", data='" + data + '\'' +
                '}';
    }


}

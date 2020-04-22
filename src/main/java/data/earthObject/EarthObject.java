package data.earthObject;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class EarthObject {
    private String date;
    private String id;
    private Resource resource;
    private String service_version;
    private String url;

}

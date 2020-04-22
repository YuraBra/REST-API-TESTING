
package data.asteroidsObject;

//import com.sun.xml.internal.ws.developer.Serialization;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
import java.util.Map;

@Getter
@ToString
public class AsteroidObject {

    private Links links;
    private Integer element_count;
    private Map<String, List<Date>> near_earth_objects;

}

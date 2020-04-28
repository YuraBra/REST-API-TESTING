
package scooter.data;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class ScooterDto {

    private String id;
    private String modelName;
    private String serialNumber;
    private String registerDate;
    private Object expireDate;
    private String status;

}

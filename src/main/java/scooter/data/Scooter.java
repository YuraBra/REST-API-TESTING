package scooter.data;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Scooter {

    private String modelName;
    private String serialNumber;

    public Scooter(String modelName, String serialNumber) {
        this.modelName = modelName;
        this.serialNumber = serialNumber;
    }
}

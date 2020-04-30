package scooter.data;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class ScooterDTOForUser {
    private String id;
    private String status;
    private GpsPoint gpsPoint;
    private int battery;
}

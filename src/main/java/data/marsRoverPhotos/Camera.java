package data.marsRoverPhotos;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Camera {

    private Integer id;
    private String name;
    private Integer rover_id;
    private String full_name;
}
package nasa.data.marsRoverPhotos;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Photo {

    private Integer id;
    private Integer sol; //time it takes Mars to revolve once around its own axis
    private Camera camera;
    private String img_src;
    private String earth_date;
    private Rover rover;
}
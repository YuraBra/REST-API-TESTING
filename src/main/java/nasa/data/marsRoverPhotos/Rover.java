package nasa.data.marsRoverPhotos;

import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@ToString
public class Rover {

    private Integer id;
    private String name;
    private String landing_date;
    private String launch_date;
    private String status;
    private Integer max_sol;
    private String max_date;
    private Integer total_photos;
    private List<Camera> cameras;

}
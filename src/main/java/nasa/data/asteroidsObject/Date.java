
package nasa.data.asteroidsObject;

import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@ToString
public class Date {

    private Links_ links;
    private String id;
    private String neo_reference_id;
    private String name;
    private String nasa_jpl_url;
    private Double absolute_magnitude_h;
    private EstimatedDiameter estimated_diameter;
    private Boolean is_potentially_hazardous_asteroid;
    private List<CloseApproachDatum> close_approach_data = null;
    private Boolean is_sentry_object;

}

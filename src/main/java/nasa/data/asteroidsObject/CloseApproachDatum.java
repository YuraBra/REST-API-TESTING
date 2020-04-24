
package nasa.data.asteroidsObject;

import lombok.Getter;
import lombok.ToString;

import java.math.BigInteger;

@Getter
@ToString
public class CloseApproachDatum {


    private String close_approach_date;
    private String close_approach_date_full;
    private BigInteger epoch_date_close_approach;
    private RelativeVelocity relative_velocity;
    private MissDistance miss_distance;
    private String orbiting_body;


}

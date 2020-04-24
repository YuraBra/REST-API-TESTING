package nasa.data.marsRoverPhotos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Getter
@ToString
@NoArgsConstructor
public class PhotoMars {

    private List<Photo> photos;
    private Integer sol;

    public PhotoMars(Integer sol) {
        this.sol = sol;
    }
}
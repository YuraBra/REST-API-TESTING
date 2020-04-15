package data;

import lombok.Getter;
import lombok.ToString;

import java.time.DateTimeException;
import java.time.ZonedDateTime;

@Getter
@ToString
public class CMEObject {
    private String time21_5;
    private Double latitude;
    private Double longitude;
    private Double halfAngle;
    private Double speed;
    private String type;
    private String isMostAccurate;
    private String associatedCMEID;
    private StringBuilder note;
    private String catalog;

//    @Override
//    public String toString() {
//        return "CMEObject{" +
//                "time21_5='" + time21_5 + '\'' +
//                ", latitude='" + latitude + '\'' +
//                ", explanation='" + explanation + '\'' +
//                ", hdurl='" + hdurl + '\'' +
//                ", media_type='" + media_type + '\'' +
//                ", service_version='" + service_version + '\'' +
//                ", title='" + title + '\'' +
//                ", url='" + url + '\'' +
//                '}';
//    }
}


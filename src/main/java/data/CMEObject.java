package data;

import lombok.Getter;
import lombok.ToString;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;
import java.util.TimeZone;

@Getter
@ToString
public class CMEObject {
    private TimeZone time21_5;
    private Double latitude;
    private Double longitude;
    private Double halfAngle;
    private Double speed;
    private String type;
    private Boolean isMostAccurate;
    private String associatedCMEID;
    private String note;
    private String catalog;

    public CMEObject() {
    }

    public CMEObject(String catalog) {
        this.catalog = catalog;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CMEObject that = (CMEObject) o;
        return Objects.equals(catalog, that.catalog);
    }

    @Override
    public int hashCode() {
        return Objects.hash(catalog);
    }

}


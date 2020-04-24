package nasa.data;

import lombok.Getter;

@Getter
public class SentryDataObject {
    private String ip;
    private String range;
    private String ps_cum;
    private String diameter;
    private String ps_max;
    private String h;
    private String last_obs;
    private String v_inf;
    private String fullname;
    private String n_imp;
    private String last_obs_jd;
    private String ts_max;
    private String id;
    private String des;

    @Override
    public String toString() {
        return "SentryDataObject{" +
                "ip='" + ip + '\'' +
                ", range='" + range + '\'' +
                ", ps_cum='" + ps_cum + '\'' +
                ", diameter='" + diameter + '\'' +
                ", ps_max='" + ps_max + '\'' +
                ", h='" + h + '\'' +
                ", last_obs='" + last_obs + '\'' +
                ", v_inf='" + v_inf + '\'' +
                ", fullname='" + fullname + '\'' +
                ", n_imp='" + n_imp + '\'' +
                ", last_obs_jd='" + last_obs_jd + '\'' +
                ", ts_max='" + ts_max + '\'' +
                ", id='" + id + '\'' +
                ", des='" + des + '\'' +
                '}';
    }
}

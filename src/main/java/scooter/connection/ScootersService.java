package scooter.connection;

import lombok.Getter;
import okhttp3.Headers;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

@Getter
public class ScootersService extends BaseScooter {
    private int responseCode;
    private String url;
    private final String ADMIN_TOKEN = "eyJhbGciOiJSUzI1NiJ9.eyJzdWIiOiJiMWMxY2E4Mi1iMTE2LTQ0YmUtOTI4Mi1mYWQ4OTI2OThmNjEiLCJyb2xlIjoiW1wiQURNSU5cIl0iLCJpc3MiOiJsb2NhbGhvc3QiLCJleHAiOjE1OTQxMjEwNDh9.CzYWsglmOeDGjELd6wlWYuUSD3TO9am7wtpPzcOtPP4P47pdk6XcYTc_3ENf_kD5f33m5ofIIvraxJu8pIiwKOOSqSIO73lhEoAwKO8Xh6hHrzcPm6ck4OnmEQO1ZHqjqwn6g0XPBx8SkUouor88cdR0x_Yrr2_4xtl9YCVP6iafjpNHyeOGBDFjbG9t8g2-_CgRYrGvZnTu8CG1YvqkzhT-u4lrOSSGZCXTaQObHAeL7osLpNcckdlRAu016tJAiz6IL-ybwjJE2nLmZsHXzjErfYc4WfpXYsSkLwVu09-wLPOEi4uTMZXhW6fMWTi2mUbyFaK0qtNzbMhvo8qgLQ";

    public ScootersService() {
        this.url = this.baseUrl + "vehicle-service/scooters/";
    }

    public String getAllScooters() throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .addHeader("Authorization", "Bearer " + ADMIN_TOKEN)
                .build();

        try (Response response = client.newCall(request).execute()) {
            responseCode = response.code();
            return response.body().string();
        }
    }

    public String getScooterById(String scooterId) throws IOException {
        Request request = new Request.Builder()
                .url(url + scooterId)
                .addHeader("Authorization", "Bearer " + ADMIN_TOKEN)
                .build();

        try (Response response = client.newCall(request).execute()) {
            responseCode = response.code();
            return response.body().string();
        }
    }

}







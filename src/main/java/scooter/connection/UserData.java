package scooter.connection;

import okhttp3.Request;
import okhttp3.Response;
import scooter.data.User;

import java.io.IOException;

public class UserData extends BaseScooter{

    private String url;

    private String token = "eyJhbGciOiJSUzI1NiJ9.eyJzdWIiOiJiMWMxY2" +
            "E4Mi1iMTE2LTQ0YmUtOTI4Mi1mYWQ4OTI2OThmNjEiLCJyb2xlIjoiW1" +
            "wiQURNSU5cIl0iLCJpc3MiOiJsb2NhbGhvc3QiLCJleHAiOjE1OTQxMjEw" +
            "NDh9.CzYWsglmOeDGjELd6wlWYuUSD3TO9am7wtpPzcOtPP4P47pdk6XcYTc_" +
            "3ENf_kD5f33m5ofIIvraxJu8pIiwKOOSqSIO73lhEoAwKO8Xh6hHrzcPm6ck" +
            "4OnmEQO1ZHqjqwn6g0XPBx8SkUouor88cdR0x_Yrr2_4xtl9YCVP6iafjpNHye" +
            "OGBDFjbG9t8g2-_CgRYrGvZnTu8CG1YvqkzhT-u4lrOSSGZCXTaQObHAeL7osLp" +
            "NcckdlRAu016tJAiz6IL-ybwjJE2nLmZsHXzjErfYc4WfpXYsSkLwVu09-wLPOE" +
            "i4uTMZXhW6fMWTi2mUbyFaK0qtNzbMhvo8qgLQ";

    public UserData(User user) {
        this.url = this.baseUrl + "identity-service/accounts/" + user.getId();
    }

    public /*String*/  int run() throws IOException {
        System.out.println(url); // DELETE
        Request request = new Request.Builder()
                .header("Authorization", "Bearer " + token)
                .url(url)
                .build();
        try (Response response = client.newCall(request).execute()) {
            return response.code();
            //return response.body().string();
        }
    }
}

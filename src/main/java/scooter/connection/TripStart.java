package scooter.connection;

import lombok.Getter;
import okhttp3.MediaType;
import okhttp3.RequestBody;

import java.io.IOException;

import static scooter.data.Data.ADMIN_TOKEN;
import static scooter.data.Data.USER_TOKEN;

@Getter
public class TripStart extends BaseScooter {
    private String tripStartUrl;

    public TripStart() {
        this.tripStartUrl = this.baseUrl + "trip-service/trips/start";
    }

    private RequestBody createBody(String userId, String scooterId) {
        String json = "{" +
                "\"userId\":\"" + userId + "\"," +
                "\"scooterId\":\"" + scooterId + "\"" +
                "}";
        return RequestBody.create(json, MediaType.parse("application/json; charset=utf-8"));
    }

    public String getResponse(String userId, String scooterId, Integer status) throws IOException {
        return post(tripStartUrl, createBody(userId, scooterId), USER_TOKEN, status);
    }
}
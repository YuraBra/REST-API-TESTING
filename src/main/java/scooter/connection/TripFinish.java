package scooter.connection;

import okhttp3.MediaType;
import okhttp3.RequestBody;

import java.io.IOException;

public class TripFinish extends BaseScooter {

    private String tripFinishUrl;

    public TripFinish() {
        this.tripFinishUrl = this.baseUrl + "trip-service/trips/finish";
    }

    private RequestBody createBody(String userId, String scooterId) {
        String json = "{" +
                "\"userId\":\"" + userId + "\"," +
                "\"scooterId\":\"" + scooterId + "\"," +
                "}";
        return RequestBody.create(json, MediaType.parse("application/json; charset=utf-8"));
    }

    public String getResponse(String userId, String scooterId) throws IOException {
        return post(tripFinishUrl, createBody(userId, scooterId));
    }
}
package scooter.connection;

import okhttp3.Request;
import okhttp3.Response;
import scooter.data.User;

import java.io.IOException;

public class UserData extends BaseScooter{

    private String url;

    public UserData(User user) {
        this.url = this.baseUrl + "identity-service/accounts/" + user.getId();
    }

    public /*int*/  String run() throws IOException {
        System.out.println(url); // DELETE
        Request request = new Request.Builder()
                .url(url)
                .build();
        try (Response response = client.newCall(request).execute()) {
            //return response.code();
            return response.body().string();
        }
    }
}

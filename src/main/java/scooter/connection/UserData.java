package scooter.connection;

import okhttp3.Request;
import okhttp3.Response;
import scooter.data.Data;

import java.io.IOException;

public class UserData extends BaseScooter{

    private String url;

    public UserData(String userID) {
        this.url = this.baseUrl + "identity-service/accounts/" + userID;
    }


    public /*String*/  int run() throws IOException {
        System.out.println(url);                                    // DELETE
        Request request = new Request.Builder()
                .header("Authorization", "Bearer " + Data.ADMIN_TOKEN)
                .url(url)
                .build();
        try (Response response = client.newCall(request).execute()) {
            return response.code();
            //return response.body().string();

        }
    }
}

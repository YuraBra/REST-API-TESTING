package scooter.connection;

import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class ActivateAccount extends BaseScooter {
    private String url;
    public ActivateAccount() {
        this.url = this.baseUrl + "identity-service/accounts/activate/";
    }

    public int run(String token) throws IOException {
        Request request = new Request.Builder()
                .url(url + token)
                .build();
        try (Response response = client.newCall(request).execute()) {
            return response.code();
        }
    }
}

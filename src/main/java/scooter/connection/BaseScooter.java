package scooter.connection;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

import java.io.IOException;

public class BaseScooter {
    protected  String baseUrl = "http://sslsecure.website/";
    protected  OkHttpClient client;

    public BaseScooter() {
        this.client = new OkHttpClient();
    }

    public String post(String url, RequestBody body) throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();
        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        }
    }
}

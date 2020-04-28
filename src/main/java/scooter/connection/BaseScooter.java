package scooter.connection;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

import java.io.IOException;
import java.net.ConnectException;

public class BaseScooter {
    protected String baseUrl = "http://sslsecure.website/";
    protected OkHttpClient client;

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

    public String post(String url, RequestBody body, String token, Integer statusCode) throws IOException {
        Request request = new Request.Builder()
                .header("Authorization", "Bearer " + token)
                .url(url)
                .post(body)
                .build();
        try (Response response = client.newCall(request).execute()) {
            if (response.code() != statusCode) {
                throw new ConnectException("Incorrect status code");
            }
            return response.body().string();
        }
    }
}
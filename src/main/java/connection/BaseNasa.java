package connection;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.net.ConnectException;

public abstract class  BaseNasa {
    protected String baseUrl = "https://api.nasa.gov/";
    protected String apiKey = "dKdXfOjwdHsGDdwseYdttVZcYZyJswhL4o86prGk";
    protected OkHttpClient client;

    public BaseNasa() {
        this.client = new OkHttpClient();
    }

    public String getResponse(Request request) throws IOException {
        try (Response response = client.newCall(request).execute()) {
            if(response.code() != 200 ){
                throw new ConnectException("Bad internet");
            }
            return response.body().string();
        }
    }
}

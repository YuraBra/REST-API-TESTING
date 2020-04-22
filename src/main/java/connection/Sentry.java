package connection;

import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class Sentry extends BaseNasa {
    private String BaseCMEUrl;

    public Sentry() {
        this.BaseCMEUrl = "https://ssd-api.jpl.nasa.gov/sentry.api";
    }

    public String run() throws IOException {
        String url = createUrl();
        Request request = new Request.Builder()
                .url(url)
                .build();

        return getResponse(request);
    }

    private String createUrl(){
        HttpUrl.Builder urlBuilder = HttpUrl.parse(BaseCMEUrl).newBuilder();
     //   urlBuilder.addQueryParameter("api_key", apiKey);
        return urlBuilder.build().toString();
    }


}

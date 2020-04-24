package nasa.connection;

import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class AsteroidsNeoWs extends BaseNasa {
    private String asteroidURL;

    public AsteroidsNeoWs() {
        asteroidURL = baseUrl + "neo/rest/v1/feed";
    }

    public String run() throws IOException {
        String url = createUrl();
        Request request = new Request.Builder()
                .url(url)
                .build();

        return getResponse(request);
    }

    public String run(String startDate) throws IOException {
        String url = createUrl(startDate);
        Request request = new Request.Builder()
                .url(url)
                .build();

        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        }
    }

    public String run(String startDate, String endDate) throws IOException {
        String url = createUrl(startDate, endDate);
        Request request = new Request.Builder()
                .url(url)
                .build();

        return getResponse(request);
    }

    private String createUrl() {
        HttpUrl.Builder urlBuilder = HttpUrl.parse(asteroidURL).newBuilder();
        urlBuilder.addQueryParameter("api_key", apiKey);
        return urlBuilder.build().toString();
    }

    private String createUrl(String startDate) {
        HttpUrl.Builder urlBuilder = HttpUrl.parse(asteroidURL).newBuilder();
        urlBuilder.addQueryParameter("api_key", apiKey);
        urlBuilder.addQueryParameter("start_date", startDate);
        return urlBuilder.build().toString();
    }

    private String createUrl(String startDate, String endDate) {
        HttpUrl.Builder urlBuilder = HttpUrl.parse(asteroidURL).newBuilder();
        urlBuilder.addQueryParameter("api_key", apiKey);
        urlBuilder.addQueryParameter("start_date", startDate);
        urlBuilder.addQueryParameter("end_date", endDate);
        return urlBuilder.build().toString();
    }
}

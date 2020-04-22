package connection;

import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class Earth extends BaseNasa {
    private String BaseEarthUrl;

    public Earth() {
        this.BaseEarthUrl = this.baseUrl + "planetary/earth/assets";
    }

    public String run(Float lon, Float lat) throws IOException {
        String url = createUrl(lon.toString(), lat.toString());
        Request request = new Request.Builder()
                .url(url)
                .build();

        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        }
    }

    private String createUrl(String lon, String lat){
        HttpUrl.Builder urlBuilder = HttpUrl.parse(BaseEarthUrl).newBuilder();
        urlBuilder.addQueryParameter("lon", lon);
        urlBuilder.addQueryParameter("lat", lat);
        urlBuilder.addQueryParameter("api_key", apiKey);
        return urlBuilder.build().toString();
    }
}

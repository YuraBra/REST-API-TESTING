package nasa.connection;

import okhttp3.HttpUrl;
import okhttp3.Request;

import java.io.IOException;

public class MarsRoverPhotos extends BaseNasa {

    private String baseMarsRoverPhotosUrl;

    public MarsRoverPhotos() {
        this.baseMarsRoverPhotosUrl = this.baseUrl + "mars-photos/api/v1/rovers/curiosity/photos";
    }

    public String run(String sol) throws IOException {
        String url = createUrl(sol);
        Request request = new Request.Builder()
                .url(url)
                .build();

        return getResponse(request);
    }

    private String createUrl(String sol) {
        HttpUrl.Builder urlBuilder = HttpUrl.parse(baseMarsRoverPhotosUrl).newBuilder();
        urlBuilder.addQueryParameter("sol", sol);
        urlBuilder.addQueryParameter("api_key", apiKey);
        return urlBuilder.build().toString();
    }
}
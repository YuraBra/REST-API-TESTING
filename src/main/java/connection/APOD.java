package connection;

import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.net.ConnectException;

public class APOD extends BaseNasa {
    private String BaseAPODUrl;

    public APOD() {
        this.BaseAPODUrl = this.baseUrl + "planetary/apod";
    }

    public String run() throws IOException {
        String url = createUrl();
        Request request = new Request.Builder()
                .url(url)
                .build();
        return getResponse(request);
    }

    public String run(String date) throws IOException {
        String url = createUrl(date);
        Request request = new Request.Builder()
                .url(url)
                .build();

        return getResponse(request);
    }

    private String createUrl(){
        HttpUrl.Builder urlBuilder = HttpUrl.parse(BaseAPODUrl).newBuilder();
        urlBuilder.addQueryParameter("api_key", apiKey);
        return urlBuilder.build().toString();
    }

    private String createUrl(String date){
        HttpUrl.Builder urlBuilder = HttpUrl.parse(BaseAPODUrl).newBuilder();
        urlBuilder.addQueryParameter("api_key", apiKey);
        urlBuilder.addQueryParameter("date", date);
        return urlBuilder.build().toString();
    }
}

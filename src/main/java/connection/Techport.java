package connection;

import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class Techport extends BaseNasa {

    private String baseTechportURL;
    private  String techportURL;

    public Techport(){
        baseTechportURL = baseUrl + "techport/api/projects/17792";
    }
    public Techport(String id){
        baseTechportURL = baseUrl + "techport/api/projects/" + id;
    }

    public String run() throws IOException {
        techportURL = createURL();
        Request request = new Request.Builder().url(techportURL).build();
        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        }
    }

    private String createURL(){
        HttpUrl.Builder urlBuilder = HttpUrl.parse(baseTechportURL).newBuilder();
        urlBuilder.addQueryParameter("api_key", apiKey);

        return urlBuilder.build().toString();
    }



}

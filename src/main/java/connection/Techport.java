package connection;

import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class Techport extends BaseNasa {

    private String baseTechportURL;
    private  String techportURL;

    public Techport(){
        baseTechportURL = baseUrl + "techport/api/projects";
    }

    public String run(String id) throws IOException {
        techportURL = createURL(id);
        Request request = new Request.Builder().url(techportURL).build();
        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        }
    }

    private String createURL(String idParametr){
        HttpUrl.Builder urlBuilder = HttpUrl.parse(baseTechportURL).newBuilder();
        urlBuilder.addQueryParameter("id_parameter","/" + idParametr);
        urlBuilder.addQueryParameter("api_key", apiKey);

        return urlBuilder.build().toString();
    }

}

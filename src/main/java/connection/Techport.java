package connection;

import okhttp3.HttpUrl;

public class Techport extends BaseNasa {

    private String baseTechportURL;
    private  String techportURL;

    public Techport(){
        baseTechportURL = baseUrl + "techport/api/projects";
    }


    private String createURL(String idParametr){
        HttpUrl.Builder urlBuilder = HttpUrl.parse(baseTechportURL).newBuilder();
        urlBuilder.addQueryParameter("id_parameter","/" + idParametr);
        urlBuilder.addQueryParameter("api_key", apiKey);

        return urlBuilder.build().toString();
    }

}

package scooter.connection;

import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

import java.io.IOException;
import java.util.Objects;

public class SignIn extends BaseScooter {
    private String url;
    public final String replace = "Bearer ";
    public final  String emptyString = "";

    public SignIn() {
        this.url = this.baseUrl + "identity-service/accounts/sign-in";
    }

    private RequestBody createBody(String email, String password){
        String json = "{" +
                "\"email\":\"" + email + "\"," +
                "\"password\":\""+ password + "\"" +
                "}";
        return  RequestBody.create(json, MediaType.parse("application/json; charset=utf-8"));
    }

    public Response getResponse(String email, String password) throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .post(createBody(email, password))
                .build();
        try (Response response = client.newCall(request).execute()) {
            return response;
        }
    }

    public String getUserToken (String email, String password) throws IOException {
        return getResponse(email, password).header("Authorization").replace(replace, emptyString);
    }
}

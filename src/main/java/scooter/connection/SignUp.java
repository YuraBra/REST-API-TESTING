package scooter.connection;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import scooter.data.User;

import java.io.IOException;

import static scooter.Randomizing.getRandomizedEmail;


public class SignUp extends BaseScooter {
    private String url;

    public SignUp() {
        this.url = this.baseUrl + "identity-service/accounts/sign-up";
    }

    private RequestBody createBody(String email, String firstName, String lastName, String password, boolean isRandEmail){
        String json = "{" +
                "\"email\":\"" + (isRandEmail? getRandomizedEmail(email): email) + "\"," +
                "\"firstName\":\""+ firstName +"\"," +
                "\"lastName\":\"" + lastName + "\"," +
                "\"password\":\""+ password + "\"" +
                "}";
        return  RequestBody.create(json, MediaType.parse("application/json; charset=utf-8"));
    }

    public String getResponse(String email, String firstName, String lastName, String password, boolean isRandEmail) throws IOException {
        return post(url, createBody(email, firstName, lastName, password, isRandEmail));
    }

    public String getResponse(User user, boolean isRandEmail) throws IOException {
        return post(url, createBody(user.getEmail(), user.getFirstName(), user.getLastName(), user.getPassword(), isRandEmail));
    }
}

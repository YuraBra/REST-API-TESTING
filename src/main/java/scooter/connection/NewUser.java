package scooter.connection;

import okhttp3.Request;
import scooter.data.User;
import scooter.util.RequestUtil;
import java.io.IOException;

public class NewUser extends BaseScooter {
    private String url;
    private final static String SYMBOL = "\"";
    private final static String EMPTY_STRING = "";

    public NewUser() {
        this.url = this.baseUrl + "identity-service/accounts/sign-up";
    }

    public String getRegistrationUserToken(User user) throws IOException {
        RequestUtil requestUtil = new RequestUtil();
        Request request = requestUtil.postRequest(url, user);
        return requestUtil.getResponse(request).replace(SYMBOL, EMPTY_STRING);
    }
}

package scooter.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import scooter.connection.ActivateAccount;
import scooter.connection.SignIn;
import scooter.connection.SignUp;
import scooter.connection.UserData;
import scooter.data.Data;
import scooter.data.User;
import scooter.util.SubStringSearcher;
import scooter.util.TokenDecoder;


import java.io.IOException;
import java.util.Objects;

public class TestForUserData {

    User user;
    String activateToken;
    String bearerCode;


    @Before
    public void createUser() throws IOException {

        user = new User(Data.emailUserDataTest_1, Data.passwordUserDataTest_1, Data.firstNameUserDataTest_1, Data.lastNameUserDataTest_1);
        SignUp signUp = new SignUp();
        activateToken = signUp.getResponse(user);
        System.out.println("Step 1");
        System.out.println(activateToken);
        ActivateAccount acc = new ActivateAccount();
        int actualCode = acc.run(activateToken.replace("\"", ""));
        System.out.println("Step 2");
        System.out.println(actualCode);
        SignIn signIn = new SignIn();
        bearerCode = Objects.requireNonNull(signIn.getResponse(Data.emailUserDataTest_1, Data.passwordUserDataTest_1)
                .header("Authorization")).replace("Bearer ", "");
        System.out.println("Step 3");
        System.out.println(bearerCode);
    }

    private String getUserIdFromDecodedToken(String token) {

        String body = TokenDecoder.getBodyFromToken(token);
        String userID = SubStringSearcher.getSubString(body,Data.firstSubStrForUserID,Data.secondSubStrForUserID);
        return userID;
    }

    private String getMail(String jsonAnswer){

        String mail = SubStringSearcher.getSubString(jsonAnswer, Data.firstSubStrForUserMail,Data.secondSubStrForUserMail);
        return mail;
    }

    @Test
    public void getUserData() {
        String respSerID;
        String actualMailFromJSON;
        String userId = getUserIdFromDecodedToken(bearerCode);
        UserData userData = new UserData(userId);
        try {
            respSerID = userData.run();
            System.out.println("Step 7");
            System.out.println(respSerID);
            actualMailFromJSON = getMail(respSerID);
            Assert.assertEquals("testforapi.i@mail.com", actualMailFromJSON);
        } catch (IOException e) {
            Assert.fail();
        }
    }


}

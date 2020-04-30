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


    String bearerCode;


    @Before
    public void createUser() throws IOException {       // getToken

        User user = new User(Data.emailUserDataTest_1, Data.passwordUserDataTest_1, Data.firstNameUserDataTest_1, Data.lastNameUserDataTest_1);
        SignUp signUp = new SignUp();
        String activateToken = signUp.getResponse(user);
        System.out.println("Step 1");
        System.out.println(activateToken);
        ActivateAccount acc = new ActivateAccount();
        int actualCode = acc.run(activateToken.replace("\"", ""));
        System.out.println("Step 2");
        System.out.println(actualCode);
        SignIn signIn = new SignIn();
        bearerCode = Objects.requireNonNull(signIn.getResponse(Data.emailUserDataTest_1, Data.passwordUserDataTest_1) // user.getMail; user.getpassword
                .header("Authorization")).replace("Bearer ", "");
        System.out.println("Step 3");
        System.out.println(bearerCode);
    }


    @Test
    public void getUserData() {
        String userDataJson;
        String actualMailFromJSON;
        String body = TokenDecoder.getBodyFromToken(bearerCode);            // Data.Token1;
        String userID = SubStringSearcher.getSubString(body,Data.firstSubStrForUserID,Data.secondSubStrForUserID);

        UserData userData = new UserData(userID);
        try {
            userDataJson = userData.run();
            System.out.println("Step 7");       // DELETE
            System.out.println(userDataJson);   // DELETE
            actualMailFromJSON = SubStringSearcher.getSubString(userDataJson, Data.firstSubStrForUserMail,Data.secondSubStrForUserMail);
            Assert.assertEquals("testforapi.i@mail.com", actualMailFromJSON);
        } catch (IOException e) {
            Assert.fail();
        }
    }


}

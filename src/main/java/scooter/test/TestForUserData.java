package scooter.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import scooter.connection.ActivateAccount;
import scooter.connection.SignIn;
import scooter.connection.SignUp;
import scooter.connection.UserData;
import scooter.data.UserDataDto;
import org.apache.commons.codec.binary.Base64;


import java.io.IOException;
import java.util.Objects;

public class TestForUserData {

    UserDataDto userDataDto;
    String activateToken;
    String bearerCode;

    String email = "testforapi.i@mail.com";
    String password = "qwerty";
    String firstName = "Alex9";
    String lastName = "Bor9";

    @Before
    public void createUser() throws IOException {
        userDataDto = new UserDataDto(email, password, firstName, lastName);
        SignUp signUp = new SignUp();
        activateToken = signUp.getResponse(userDataDto);
        System.out.println("Step 1");
        System.out.println(activateToken);
        ActivateAccount acc = new ActivateAccount();
        int actualCode = acc.run(activateToken.replace("\"", ""));
        System.out.println("Step 2");
        System.out.println(actualCode);
        SignIn signIn = new SignIn();
        bearerCode = Objects.requireNonNull(signIn.getResponse(email, password)
                .header("Authorization")).replace("Bearer ", "");
        System.out.println("Step 3");
        System.out.println(bearerCode);
    }

    private String getUserIdFromDecodedToken(String token) {

        String[] split_string = token.split("\\.");
        String base64EncodedBody = split_string[1];
        Base64 base64Url = new Base64(true);
        System.out.println("Step 4 decoded token");
        String body = new String(base64Url.decode(base64EncodedBody));
        System.out.println(body);

        String firstSubStr = "{\"sub\":\"";
        int first = body.indexOf(firstSubStr);
        String secondSubStr = "\",\"role";
        int second = body.indexOf(secondSubStr);
        String subStr = body.substring(first + firstSubStr.length(), second);
        System.out.println("Step 5");
        System.out.println(subStr);
        return subStr;
    }

    private String getMail(String jsonAnswer){

        String firstSubStr = "{\"email\":\"";
        int first = jsonAnswer.indexOf(firstSubStr);
        String secondSubStr = "\",\"firstN";
        int second = jsonAnswer.indexOf(secondSubStr);
        String subStr = jsonAnswer.substring(first + firstSubStr.length(), second);
        System.out.println("Step 6");
        System.out.println(subStr);
        return subStr;
    }

    private String searchSubString(String str,String firstSubStr,String secondSubStr){
        return null;
    }


    @Test
    public void getUserData() {
        int actualStatus;
        String respSerID;
        String actualMailFromJSON;
        String userId = getUserIdFromDecodedToken(bearerCode);
        UserData userData = new UserData(userId);
        try {
            respSerID = userData.run();
            System.out.println("Step 7");
            System.out.println(respSerID);
            actualMailFromJSON = getMail(respSerID);
            Assert.assertEquals("String", actualMailFromJSON);
        } catch (IOException e) {
            Assert.fail();
        }
    }


}

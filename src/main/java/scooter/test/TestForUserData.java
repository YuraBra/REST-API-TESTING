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

    String email = "testforapi.h@mail.com";
    String password = "qwerty";
    String firstName = "Alex8";
    String lastName = "Bor8";
    @Before
    public void createUser() throws IOException {
        userDataDto = new UserDataDto(email,password,firstName,lastName);
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
    private String getUserIdFromDecodedToken(String token){

        String[] split_string = token.split("\\.");
        String base64EncodedBody = split_string[1];
        Base64 base64Url = new Base64(true);
        System.out.println("~~~~~~~~~ JWT Body ~~~~~~~");
        String body = new String(base64Url.decode(base64EncodedBody));
        System.out.println(body);

        String firstSubStr = "{\"sub\":\"";
        int first = body.indexOf(firstSubStr);
        String secondSubStr = "\",\"role";
        int second = body.indexOf(secondSubStr);
        String subStr = body.substring(first + firstSubStr.length(),second);
        System.out.println("Step 4");
        System.out.println(subStr);
        return subStr;
    }

    @Test
    public void getUserData(){
        int actualStatus;
        String respSerID;
        String userId = getUserIdFromDecodedToken(bearerCode);
        UserData userData = new UserData(userId);
        try {
            respSerID = userData.run();
            System.out.println("Step 5");
            System.out.println(respSerID);
            Assert.assertEquals("String", respSerID);
        } catch (IOException e) {
            Assert.fail();
        }
    }

    /*int x;
    int y;
    @Before
    public void setX(){
        x =1;
    }
    @Test
    public void setY(){
       y=2;
    }
    @Test
    public void sOut(){
        System.out.println(x);
        System.out.println(y);
    }*/


    /*UserDataDto userDataDto;
    String activateToken;
    String bearerCode;

    String email = "testforapi.f@mail.com";
    String password = "qwerty";
    String firstName = "Alex5";
    String lastName = "Bor5";

    @Before
    public void createUser(){
        userDataDto = new UserDataDto(email,password,firstName,lastName);
    }
    @Test
    public void setUpUser(){
        SignUp signUp = new SignUp();

        try{
            activateToken = signUp.getResponse(userDataDto);
            System.out.println("Step 1");
            System.out.println(activateToken);
        }catch (IOException e){ }                   // + Assert & Exception
    }
    @Test
    public void activateUser(){
        ActivateAccount acc = new ActivateAccount();
        try{
            //int actualCode = acc.run(activateToken.replace("\"", ""));
            int actualCode = acc.run(activateToken.replace("\"", ""));
            System.out.println("Step 2");
            System.out.println(actualCode);
        }catch (IOException e) { }                   // + Assert & Exception
    }
    @Test
    public void singInUser(){
        SignIn signIn = new SignIn();
        try {
            bearerCode = Objects.requireNonNull(signIn.getResponse(email, password)
                    .header("Authorization")).replace("Bearer ", "");
            System.out.println("Step 3");
            System.out.println(bearerCode);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    // сделан
    private String getUserIdFromDecodedToken(String token){

        String[] split_string = token.split("\\.");
        String base64EncodedBody = split_string[1];
        Base64 base64Url = new Base64(true);
        System.out.println("~~~~~~~~~ JWT Body ~~~~~~~");
        String body = new String(base64Url.decode(base64EncodedBody));
        System.out.println(body);

        String firstSubStr = "{\"sub\":\"";
        int first = body.indexOf(firstSubStr);
        String secondSubStr = "\",\"role";
        int second = body.indexOf(secondSubStr);
        String subStr = body.substring(first + firstSubStr.length(),second);
        System.out.println("Step 4");
        System.out.println(subStr);
        return subStr;
    }

    @Test
    public void getUserData(){
        int actualStatus;
        String userId = getUserIdFromDecodedToken(bearerCode);
        UserData userData = new UserData(userId);
        try {
            actualStatus = userData.run();
            System.out.println("Step 5");
            System.out.println(actualStatus);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/

}

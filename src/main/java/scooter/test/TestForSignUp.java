package scooter.test;

import org.junit.Assert;
import org.junit.Test;
import scooter.connection.SignUp;

import java.io.IOException;

public class TestForSignUp {
    public int expectedLength = 38;

    public final String email = "dp184taqc@gmail.com";
    public final  String firstName = "Engineer";
    public final String lastName = "QA";
    public final String password = "qwerty";
    public final boolean isRandEmail = true;

    @Test
    public void testSignUpFunctionality(){
        SignUp signUp = new SignUp();
        try{
            String resp = signUp.getResponse(email, firstName, lastName, password, isRandEmail);
            Assert.assertEquals(expectedLength, resp.length());
        }catch (IOException e){
            Assert.fail();
        }
    }
}

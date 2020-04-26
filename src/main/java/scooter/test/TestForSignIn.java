package scooter.test;

import org.junit.Assert;
import org.junit.Test;
import scooter.connection.SignIn;

import java.io.IOException;
import java.util.Objects;

public class TestForSignIn {
    public int expectedBearerCodeLength = 499;

    public final String email = "dp184test@gmail.com";
    public final String password = "qwerty";
    public final String replace = "Bearer ";
    public final  String emptyString = "";

    @Test
    public void testSignInFunctionality(){
        SignIn signIn = new SignIn();
        try{
            String bearerCode = Objects.requireNonNull(signIn.getResponse(email, password)
                    .header("Authorization")).replace(replace, emptyString);
            Assert.assertEquals(expectedBearerCodeLength, bearerCode.length());
        }catch (IOException e) {
            Assert.fail();
        }
    }
}

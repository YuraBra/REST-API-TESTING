package scooter.test;

import org.junit.Assert;
import org.junit.Test;
import scooter.connection.ActivateAccount;
import scooter.connection.SignUp;

import java.io.IOException;

public class TestForActivateAccount {
    public int expectedStatusCode = 204;

    public final String email = "dp184taqc@gmail.com";
    public final  String firstName = "Engineer";
    public final String lastName = "QA";
    public final String password = "qwerty";
    public final boolean isRandEmail = true;
    public final String token = getToken();

    @Test
    public void testActivateAccountFunctionality(){
        ActivateAccount acc = new ActivateAccount();
        try{
            int actual = acc.run(token);
            Assert.assertEquals(expectedStatusCode, actual);
        }catch (IOException e){
            Assert.fail();
        }
    }
    private String getToken(){
        try{
          return (new SignUp().getResponse(email, firstName, lastName, password, isRandEmail)).replace("\"", "");
        }catch (IOException e){
            return null;
        }
    }
}

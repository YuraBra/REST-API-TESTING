package scooter.test;

import org.junit.Assert;
import org.junit.Test;
import scooter.connection.ActivateAccount;
import scooter.connection.NewUser;
import scooter.data.Data;
import scooter.data.User;
import java.io.IOException;

public class TestForActivateAccount extends BaseTest{
    private final static int expectedStatusCode = 204;
    private String token = getToken();

    @Test
    public void testActivateAccountFunctionality(){
        if(token != null){
            try{
                int actual = new ActivateAccount().activateUserToken(token);
                Assert.assertEquals("Status code isn't " + expectedStatusCode, expectedStatusCode, actual);
            } catch (IOException e) {
                Assert.fail(e.getMessage());
            }
        }
    }

    private String getToken(){
        User user = new User(Data.EMAIL, Data.PASSWORD, Data.FIRST_NAME, Data.LAST_NAME);
        try{
          return new NewUser().getRegistrationUserToken(user);
        } catch (Exception e) {
            return null;
        }
    }
}

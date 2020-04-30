package scooter.test;

import com.fasterxml.jackson.core.JsonProcessingException;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import scooter.connection.NewUser;
import scooter.data.Data;
import scooter.data.User;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;

@RunWith(JUnitParamsRunner.class)
public class TestForNewUser extends BaseTest{
    public int expectedLength = 36;

    public static Collection<Object[]> inputDataPositive(){
        return Arrays.asList(new Object[][]{
                {new User(Data.EMAIL, Data.PASSWORD, Data.FIRST_NAME, Data.LAST_NAME)},
                {new User(Data.EMAIL, Data.PASSWORD, Data.FIRST_NAME, Data.LAST_NAME)},
                {new User(Data.EMAIL, Data.PASSWORD, Data.FIRST_NAME, Data.LAST_NAME)},
        });
    }

    @Test
    @Parameters(method = "inputDataPositive")
    public void testSignUpFunctionality(User user) {
        NewUser newUser = new NewUser();
        try {
            String resp = newUser.getRegistrationUserToken(user);
            Assert.assertEquals("Length of registration token isn't "+ expectedLength +  " chars", expectedLength, resp.length());
        } catch (JsonProcessingException e) {
            Assert.fail("Can't create json from user Entity");
        } catch (IOException e) {
            Assert.fail(e.getMessage());
        }
    }
}

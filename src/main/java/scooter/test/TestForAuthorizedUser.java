package scooter.test;

import com.fasterxml.jackson.core.JsonProcessingException;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import scooter.connection.AuthorizedUser;
import scooter.data.Data;
import scooter.data.User;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;

@RunWith(JUnitParamsRunner.class)
public class TestForAuthorizedUser {
    public int expectedBearerTokenLength = 499;

    public static Collection<Object[]> inputDataPositive(){
        return Arrays.asList(new Object[][]{
                {new User(Data.EMAIL, Data.PASSWORD)},
                {new User(Data.EMAIL_2, Data.PASSWORD_2)},
        });
    }

    @Test
    @Parameters(method = "inputDataPositive")
    public void testAuthorizedUser(User user){
        AuthorizedUser authorizedUser = new AuthorizedUser();
        try{
            String actualBearerToken = authorizedUser.getBearerTokenAuthorizedUser(user);
            Assert.assertEquals(expectedBearerTokenLength, actualBearerToken.length());
        } catch (JsonProcessingException e) {
            Assert.fail("Can't create json from user Entity");
        } catch (IOException e) {
            Assert.fail(e.getMessage());
        }
    }
}

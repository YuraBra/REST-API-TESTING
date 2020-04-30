package scooter.test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import scooter.connection.UserData;
import scooter.data.Data;
import scooter.util.SubStringSearcher;
import scooter.util.TokenDecoder;


import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;

@RunWith(value = Parameterized.class)
public class TestForUserData {

    private String token;
    private String expectedMail;

    public TestForUserData(String token, String expectedMail) {
        this.token = token;
        this.expectedMail = expectedMail;
    }

    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {Data.USER_TOKEN_USER_DATA_TEST_1, Data.EMAIL_USER_DATA_TEST_1},
                {Data.USER_TOKEN_USER_DATA_TEST_2, Data.EMAIL_USER_DATA_TEST_2}
        });
    }

    @Test
    public void getUserData() {
        String userDataJson;
        String body = TokenDecoder.getBodyFromToken(token);
        String userID = SubStringSearcher.getSubString(body,Data.FIRST_SUB_STR_FOR_USER_ID,Data.SECOND_SUB_STR_FOR_USER_ID);
        UserData userData = new UserData(userID);
        try {
            userDataJson = userData.run();
            String actualMailFromJSON = SubStringSearcher.getSubString(userDataJson, Data.FIRST_SUB_STR_FOR_USER_MAIL,Data.SECOND_SUB_STR_FOR_USER_MAIL);
            Assert.assertEquals(expectedMail, actualMailFromJSON);
        } catch (IOException e) {
            Assert.fail();
        }
    }





}

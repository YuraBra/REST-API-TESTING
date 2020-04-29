package scooter.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import scooter.connection.AuthorizedUser;
import scooter.connection.Payment;
import scooter.data.User;

import java.io.IOException;

import static scooter.data.Data.*;

public class TestForUserSolvency {
    private AuthorizedUser authorizedUser;
    private User user;

    @Before
    public void signUser() throws IOException {
        authorizedUser = new AuthorizedUser();
        user = new User(EMAIL, PASSWORD);
    }

    @Test
    public void testForUserSolvency() throws IOException {
        Payment payment = new Payment(USER_ID);
        String actual = payment.getUserSolvency();
        String expected = "true";
        Assert.assertEquals("User has a card registered in the database", expected, actual);
    }
}

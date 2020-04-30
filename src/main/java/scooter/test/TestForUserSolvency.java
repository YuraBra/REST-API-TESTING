package scooter.test;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.Assert;
import org.junit.Test;
import scooter.connection.Payment;

import java.io.IOException;

import static scooter.data.Data.*;

public class TestForUserSolvency {

    @Test
    public void testForUserSolvencyWithCard(){
        Payment payment = new Payment(USER_ID1);
        try {
            String actual = payment.getUserSolvency();
            String expected = "true";
            Assert.assertEquals("Users card isn't registered in the database", expected, actual);
        } catch (JsonProcessingException e) {
            Assert.fail("Can't create json from payment");
        } catch (IOException e) {
            Assert.fail(e.getMessage());
        }
    }

    @Test
    public void testForUserSolvencyWithoutCard(){
        Payment payment = new Payment(USER_ID2);
        try {
            String actual = payment.getUserSolvency();
            String expected = "false";
            Assert.assertEquals("User's card is registered in the database", expected, actual);
        } catch (JsonProcessingException e) {
            Assert.fail("Can't create json from payment");
        } catch (IOException e) {
            Assert.fail(e.getMessage());
        }
    }
}

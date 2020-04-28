package scooter.test;

import org.junit.Assert;
import org.junit.Test;
import scooter.connection.Card;
import scooter.data.CardObject;

import java.io.IOException;

public class TestForAddCard {
    public int expectedStatusCode = 200;

    private CardObject userCard = new CardObject("4242424242424242", 123,
            "9a27f6c9-3744-44a6-98ef-ef8d176dc262", "2020-12");
    public String expectedResponse = "card was successful added";

    @Test
    public void testForAddCard() {
        Card card = new Card();
        try {
            String actual = card.getResponse(userCard.getCardNumber(), userCard.getCvc(), userCard.getUserUUID(), userCard.getYearMonth());
            Assert.assertEquals(expectedResponse, actual);
        } catch (IOException e) {
            Assert.fail();
        }//токен? второй асерт статус 200?
    }

}

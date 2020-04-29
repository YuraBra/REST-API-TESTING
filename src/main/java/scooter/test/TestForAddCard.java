package scooter.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import scooter.connection.Card;
import scooter.connection.SignIn;
import scooter.data.CardObject;

import java.io.IOException;

import static scooter.data.Data.*;

public class TestForAddCard {

    private SignIn signIn;
    private String userToken;
    private CardObject userCard;
    private String expectedResponse = "card was successful added";

    @Before
    public void signUser() throws IOException {
        signIn = new SignIn();
        userToken = signIn.getUserToken(EMAIL, PASSWORD);
    }

    @Test
    public void testForAddCard() {
        userCard = new CardObject(CARD_NUMBER, CVC, USER_ID, YEAR_MONTH);
        Card card = new Card();
        try {
            String actual = card.getResponseCard(userCard.getCardNumber(), userCard.getCvc(),
                    userCard.getUserUUID(), userCard.getYearMonth(), userToken, 200);
            Assert.assertEquals(expectedResponse, actual);
        } catch (IOException e) {
            Assert.fail();
        }//добавить делит
    }

}

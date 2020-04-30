package scooter.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import scooter.services.AuthorizedUser;
import scooter.services.Card;
import scooter.data.CardObject;
import scooter.data.User;

import java.io.IOException;

import static scooter.data.Data.*;

public class TestForAddCard extends BaseTest{

    private AuthorizedUser autorizedUser;
    private String userToken;
    private User user;
    private CardObject userCard;
    private String expectedResponse = "card was successful added";

    @Before
    public void signUser() throws IOException {
        autorizedUser = new AuthorizedUser();
        user = new User(EMAIL, PASSWORD);
        userToken = autorizedUser.getBearerTokenAuthorizedUser(user);
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

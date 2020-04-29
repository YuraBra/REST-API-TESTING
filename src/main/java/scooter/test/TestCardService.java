package scooter.test;

import lombok.Data;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import scooter.connection.CardService;
import scooter.connection.SignIn;
import scooter.data.CardDto;
import scooter.data.CardObject;
import scooter.data.TestDto;
import scooter.data.UserCardDto;

import java.io.IOException;

import static scooter.data.Data.*;

public class TestCardService {

    private SignIn signIn;
    private String userToken;
    private CardObject userCard;
    private CardDto cardDto;
    CardService cardService = new CardService();
    private String expectedResponse = "card was successful added";

    @Before
    public void signUser() throws IOException {
        signIn = new SignIn();
        userToken = signIn.getUserToken(EMAIL, PASSWORD);
    }

    @Test
    public void testForAddCard() throws IOException {
        userCard = new CardObject(CARD_NUMBER, CVC, USER_ID, YEAR_MONTH);
        String actual = cardService.addCard(userCard);
        Assert.assertEquals("failed to add card", expectedResponse, actual);
    }

    @Test
    public void testDeleteCard() throws IOException {
//        cardDto = new CardDto(USER_ID, LAST_FOUR);
 //       cardDto = new TestDto(USER_ID, LAST_FOUR);

        String cardUser = cardService.deleteCard();
        System.out.println(cardUser);
       // Assert.assertEquals("failed to delete card", LAST_FOUR, cardUser);
    }

}

package scooter.test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.exc.MismatchedInputException;
import org.junit.Assert;
import org.junit.Test;
import scooter.services.CardService;
import scooter.data.CardObject;
import scooter.data.UserCardDto;

import java.io.IOException;

import static scooter.data.Data.*;

public class TestCardService extends BaseTest{

    private CardObject userCard;
    CardService cardService = new CardService();
    private String expectedResponse = "card was successful added";

    @Test
    public void testForAddCard() {
        userCard = new CardObject(CARD_NUMBER, CVC, USER_ID, YEAR_MONTH);
        try{
            String actual = cardService.addCard(userCard);
            Assert.assertEquals("failed to add card", expectedResponse, actual);
        } catch (JsonProcessingException e) {
            Assert.fail("can't create JSON from card entity");
        } catch (IOException e) {
            Assert.fail(e.getMessage());
        }
    }

    @Test
    public void testDeleteCard() {
        try {
            UserCardDto userCardDto = cardService.deleteCard();
            Assert.assertEquals("failed to delete card", LAST_FOUR, userCardDto.getLast4());
        } catch (MismatchedInputException e) {
            Assert.fail("Empty response body");
        } catch (JsonProcessingException e) {
            Assert.fail("can't create JSON from card entity");
        } catch (IOException e) {
            Assert.fail(e.getMessage());
        }
    }
}

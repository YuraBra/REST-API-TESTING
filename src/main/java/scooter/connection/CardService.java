package scooter.connection;

import okhttp3.Request;
import scooter.data.CardDto;
import scooter.data.CardObject;
import scooter.data.TestDto;
import scooter.data.UserCardDto;
import scooter.util.RequestUtil;

import java.io.IOException;

import static scooter.data.Data.USER_TOKEN;

public class CardService extends BaseScooter {
    private String url;
    private RequestUtil requestUtil;

    public CardService() {
        this.url = this.baseUrl + "payment-service/cards";
        this.requestUtil = new RequestUtil();
    }

    public String addCard(CardObject cardObject) throws IOException {
        Request request = requestUtil.postRequest(url, cardObject, USER_TOKEN);
        return requestUtil.getResponse(request);
    }

    public String deleteCard() throws IOException {
        CardDto payload = new CardDto();
        payload.setUserUUID("9a27f6c9-3744-44a6-98ef-ef8d176dc262");
        payload.setLastFour("4242");
        Request request = requestUtil.deleteRequest(url, payload, USER_TOKEN);
        return requestUtil.getResponse(request);
    }
}

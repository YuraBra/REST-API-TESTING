package scooter.connection;

import okhttp3.MediaType;
import okhttp3.RequestBody;

import java.io.IOException;

import static scooter.Randomizing.getRandomizedEmail;

public class Card extends BaseScooter {
    private String url;
    public Card (){
        this.url = this.baseUrl + "payment-service/cards";
    }

    private RequestBody createBody(String cardNumber, int cvc, String userUUID, String yearMonth){
        String json = "{" +
                "\"cardNumber\":\"" + cardNumber + "\"," +
                "\"cvc\":\""+ cvc +"\"," +
                "\"userUUID\":\"" + userUUID  + "\"," +
                "\"yearMonth\":\""+ yearMonth + "\"" +
                "}";
        return  RequestBody.create(json, MediaType.parse("application/json; charset=utf-8"));
    }
    public String getResponse(String cardNumber, int cvc, String userUUID, String yearMonth) throws IOException {
        return post(url, createBody(cardNumber, cvc, userUUID, yearMonth));
    }
}

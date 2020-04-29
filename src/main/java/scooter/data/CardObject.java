package scooter.data;

import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@AllArgsConstructor

public class CardObject {
    private String cardNumber;
    private int cvc;
    private String userUUID;
    private String yearMonth;
}




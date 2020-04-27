package scooter.data;

public class CardObject {
    private String cardNumber;
    private int cvc;
    private String userUUID;
    private String yearMonth;


    public CardObject(String cardNumber, int cvc, String userUUID, String yearMonth) {
        this.cardNumber = cardNumber;
        this.cvc = cvc;
        this.userUUID = userUUID;
        this.yearMonth = yearMonth;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public int getCvc() {
        return cvc;
    }

    public String getUserUUID() {
        return userUUID;
    }

    public String getYearMonth() {
        return yearMonth;
    }
}




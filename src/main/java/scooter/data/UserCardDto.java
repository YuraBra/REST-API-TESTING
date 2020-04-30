package scooter.data;

import lombok.Data;

@Data
public class UserCardDto {
   private String userUUID;
    private String cardNumber;
    private String yearMonth;
    private Integer cvc;
    private Integer last4;
    private String brand;
   private  Boolean defaulted;
}


package scooter.data;

import lombok.Getter;

@Getter
public class TripObject {

    private String userId;
    private String scooterId;

    public TripObject(String userId, String scooterId) {
        this.userId = userId;
        this.scooterId = scooterId;
    }
}
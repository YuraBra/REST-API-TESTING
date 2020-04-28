package scooter.test;

import org.junit.Test;
import scooter.connection.ScootersService;
import scooter.connection.TripStart;
import scooter.data.TripObject;

import java.io.IOException;

import static scooter.data.Data.SCOOTER_ID;
import static scooter.data.Data.USER_ID;

public class FTC_Main_API_User_StartFinishTrip {
    private ScootersService scootersService;
    private TripObject tripObject;

    //check for status scooter
    @Test
    public void testForTripStart() throws IOException {
        scootersService = new ScootersService();
        tripObject = new TripObject(USER_ID, scootersService.getRandomScooterID());
        TripStart tripStart = new TripStart();

        String actual = tripStart.getResponse(USER_ID, SCOOTER_ID, 200);
        System.out.println(actual);
//            Assert.assertEquals(expectedResponseTripId, actual);
    }

//    @Test
//    public void testForTripFinish() throws IOException {
//        TripFinish tripFinish = new TripFinish();
//            String actual = tripFinish.getResponse(tripObject.getUserId(), tripObject.getScooterId());
//            Assert.assertEquals(tripObject.getUserId(), actual);
//    }
}
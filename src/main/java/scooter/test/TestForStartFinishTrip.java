package scooter.test;

import org.junit.Assert;
import org.junit.Test;
import scooter.services.ScootersService;
import scooter.services.Trip;
import scooter.data.ScooterDto;

import java.io.IOException;
import java.util.Arrays;

import static scooter.data.Data.ADMIN_TOKEN;

public class TestForStartFinishTrip extends BaseTest{

    @Test
    public void testForTripStart() throws IOException {
        ScootersService scootersService = new ScootersService();
        ScooterDto[] allScooters = scootersService.getAllScooters();
        String scooterIdFree = Arrays.stream(allScooters)
                .filter(s -> s.getStatus().equals("FREE"))
                .findFirst()
                .get().getId();
        Trip trip = new Trip();
        trip.startTrip(scooterIdFree);
        String statusScooterAfterStart = scootersService.getScooterStatusById(scooterIdFree, ADMIN_TOKEN);
        String expected = "IN_USE";
        Assert.assertEquals("The incorrect data were used", expected, statusScooterAfterStart);
    }

    @Test
    public void testForTripFinish() throws IOException {
        ScootersService scootersService = new ScootersService();
        ScooterDto[] allScooters = scootersService.getAllScooters();
        String scooterIdFree = Arrays.stream(allScooters)
                .filter(s -> s.getStatus().equals("IN_USE"))
                .findFirst()
                .get().getId();
        Trip trip = new Trip();
        trip.finishTrip(scooterIdFree);
        String statusScooterAfterFinish = scootersService.getScooterStatusById(scooterIdFree, ADMIN_TOKEN);
        String expected = "FREE";
        Assert.assertEquals("The incorrect data were used", expected, statusScooterAfterFinish);
    }
}
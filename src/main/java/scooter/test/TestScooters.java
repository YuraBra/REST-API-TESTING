package scooter.test;

import org.junit.Assert;
import org.junit.Test;
import scooter.connection.ScootersService;

import java.io.IOException;

public class TestScooters {
    public int expectedStatusCode = 200;
    ScootersService scootersService = new ScootersService();


    @Test
    public void testGetAllScooters() throws IOException {
        scootersService.getAllScooters();
        Assert.assertEquals("", expectedStatusCode, scootersService.getResponseCode());
        System.out.println("Scooter data request completed successfully");
    }

    @Test
    public void testGetScooterByID() throws IOException {
        scootersService.getScooterById(scootersService.getRandomScooterID());
        Assert.assertEquals("", expectedStatusCode, scootersService.getResponseCode());
        System.out.println("Scooter data request by ID completed successfully");
    }
}

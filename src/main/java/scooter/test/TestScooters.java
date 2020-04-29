package scooter.test;

import org.junit.Assert;
import org.junit.Test;
import scooter.connection.ScootersService;
import scooter.data.ScooterDto;

import java.io.IOException;
import java.util.Arrays;

import static scooter.data.Data.ADMIN_TOKEN;
import static scooter.data.Data.USER_TOKEN;

public class TestScooters {
    private int expectedStatusCode = 200;
    private int expectedDeleteStatusCode = 204;
    private ScootersService scootersService = new ScootersService();


    @Test
    public void testGetAllScooters() throws IOException {
        scootersService.getAllScooters();
        Assert.assertEquals("Unexpected status code of response", expectedStatusCode, scootersService.getRequestUtil().getResponseCode());
        System.out.println("Scooter data request completed successfully");
    }

    @Test
    public void testGetScooterByID() throws IOException {
        scootersService.getScooterById(scootersService.getRandomScooterID());
        Assert.assertEquals("Unexpected status code of response", expectedStatusCode, scootersService.getRequestUtil().getResponseCode());
        System.out.println("Scooter data request by ID completed successfully");
    }

    @Test
    public void testDeleteScooter() throws IOException {
        String randomScooterId = scootersService.getRandomActiveScooterId();
//        scootersService.deleteScooterById(randomScooterId);
        Assert.assertEquals("Unexpected status code of response", expectedDeleteStatusCode, scootersService.getRequestUtil().getResponseCode());

        String statusOfDeletedScooter = Arrays.stream(scootersService.getAllScooters()).
                filter(s -> s.getId().equals(randomScooterId))
                .findFirst().get()
                .getStatus();
        Assert.assertEquals(scootersService.DECOMMISSIONED, statusOfDeletedScooter);
        System.out.println("Scooter status successfully changed to decommissioned");
    }

    @Test
    public void testAddedScooter() throws IOException {
        String randomScooterId = scootersService.getRandomActiveScooterId();
        String scooterStatusByIdAsUser = scootersService.getScooterStatusById(randomScooterId, USER_TOKEN);
        String scooterStatusByIdAsAdmin = scootersService.getScooterStatusById(randomScooterId, ADMIN_TOKEN);
        Assert.assertEquals(scooterStatusByIdAsUser, scooterStatusByIdAsAdmin);
    }

}

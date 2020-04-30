package scooter.test;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.*;
import org.junit.runner.RunWith;
import scooter.services.ScootersService;
import scooter.data.ScooterDto;
import scooter.util.ScooterType;

import java.io.IOException;

import static scooter.data.Data.*;
import static scooter.util.ScooterType.*;

@RunWith(JUnitParamsRunner.class)
public class TestScooterStatus extends BaseTest{

    private ScootersService scootersService = new ScootersService();
    private String newScooterId;

    @Before
    public void createScooter () throws IOException {
        newScooterId = scootersService.getNewScooterById();
    }

    @After
    public void deleteScooter () throws IOException {
        scootersService.getNewStatusScooterById(newScooterId, inspect);
        scootersService.deleteScooterById(newScooterId);
        ScooterDto scooterStatus = scootersService.getScooterById(newScooterId, ADMIN_TOKEN);
        String scooter = scooterStatus.getStatus();
        System.out.println("scooter Status is:" + scooter);
    }

    public static Object[][] testCheckChangeScooterStatus() {
        return new Object[][]{
                {free, acquire, ACQUIRE},
                {acquire, free, FREE},
                {free, inspect, INSPECT},
                {inspect, free, FREE},
                {inspect, acquire, ACQUIRE},
                {acquire, inspect, INSPECT},
                {free, retrieve, RETRIEVE},
                {retrieve, free, FREE},
                {inspect, retrieve, INSPECT}
        };
    }

    @Test
    @Parameters(method = "testCheckChangeScooterStatus")
    public void testChangeScooterStatus(ScooterType firstType, ScooterType nextType, String expected) throws IOException {
        scootersService.getNewStatusScooterById(newScooterId, firstType);
        scootersService.getNewStatusScooterById(newScooterId, nextType);
        String actual = scootersService.getScooterStatusById(newScooterId, ADMIN_TOKEN);
        Assert.assertEquals("Scooter status is not equal", expected, actual);
    }
}

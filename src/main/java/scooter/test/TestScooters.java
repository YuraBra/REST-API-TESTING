package scooter.test;

import nasa.parsing.Parsing;
import org.junit.Assert;
import org.junit.Test;
import scooter.connection.ScootersService;
import scooter.data.ScooterDto;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

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
        scootersService.getScooterById(getRandomScooterID());
        Assert.assertEquals("", expectedStatusCode, scootersService.getResponseCode());
        System.out.println("Scooter data request by ID completed successfully");
    }

    private String getRandomScooterID() throws IOException {
        Parsing parsing = new Parsing(ScooterDto[].class, scootersService.getAllScooters());
        ScooterDto[] scooterDtos = (ScooterDto[]) parsing.parseDataFromJson();
        List<ScooterDto> scooterDtoList = Arrays.asList(scooterDtos);
        return scooterDtoList.get(new Random().nextInt(scooterDtoList.size())).getId();
    }
}

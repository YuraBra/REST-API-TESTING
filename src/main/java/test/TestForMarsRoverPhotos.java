package test;

import Parsing.Parsing;
import connection.MarsRoverPhotos;
import data.APODObject;
import data.marsRoverPhotos.PhotoMars;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import testData.MarsRoverPhotosTestData;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;

@RunWith(JUnitParamsRunner.class)
public class TestForMarsRoverPhotos {

    public static Collection<Object[]> inputData() {
        return Arrays.asList(new Object[][]{
                {MarsRoverPhotosTestData.sol1, MarsRoverPhotosTestData.marsRoverPhotos1},
                {MarsRoverPhotosTestData.sol2, MarsRoverPhotosTestData.marsRoverPhotos2},
                {MarsRoverPhotosTestData.sol3, MarsRoverPhotosTestData.marsRoverPhotos3},
                {MarsRoverPhotosTestData.sol4, MarsRoverPhotosTestData.marsRoverPhotos4}
        });
    }

    @Test
    @Parameters(method = "inputData")
    public void testConvertFromIntToArrayInt(String sol, PhotoMars photoMars) throws IOException {
        MarsRoverPhotos marsRoverPhotos = new MarsRoverPhotos();
        String response = marsRoverPhotos.run("1");
        PhotoMars object = (PhotoMars) new Parsing(new APODObject(), response).parseDataFromJson();
        Assert.assertEquals(object, marsRoverPhotos);
    }
}
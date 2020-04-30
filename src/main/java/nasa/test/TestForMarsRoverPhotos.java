package nasa.test;

import nasa.parsing.Parsing;
import nasa.services.MarsRoverPhotos;
import nasa.data.marsRoverPhotos.Photo;
import nasa.data.marsRoverPhotos.PhotoMars;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import nasa.testData.MarsRoverPhotosTestData;
import scooter.test.BaseTest;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@RunWith(JUnitParamsRunner.class)
public class TestForMarsRoverPhotos extends BaseTest {

    public static Collection<Object[]> inputData() {
        return Arrays.asList(new Object[][]{
                {MarsRoverPhotosTestData.sol1},
                {MarsRoverPhotosTestData.sol2},
                {MarsRoverPhotosTestData.sol3},
                {MarsRoverPhotosTestData.sol4}
        });
    }

    @Test
    @Parameters(method = "inputData")
    public void testForPhotos(Integer sol) throws IOException {
        MarsRoverPhotos marsRoverPhotos = new MarsRoverPhotos();
        String response = marsRoverPhotos.run(sol.toString());
        Parsing pars = new Parsing(PhotoMars.class, response);
        PhotoMars object = (PhotoMars) pars.parseDataFromJson();
        List<Photo> photos = object.getPhotos();
        for (Photo photo : photos) {
            Assert.assertEquals("parameter sol is not similar", sol, photo.getSol());
        }
    }
}
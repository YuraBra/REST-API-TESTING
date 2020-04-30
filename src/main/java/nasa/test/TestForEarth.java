package nasa.test;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import nasa.services.Earth;
import nasa.data.earthObject.EarthObject;
import nasa.parsing.Parsing;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import scooter.test.BaseTest;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;

@RunWith(JUnitParamsRunner.class)
public class TestForEarth extends BaseTest {

    public static Collection<Object[]> inputDataPositive() {
        return Arrays.asList(new Object[][]{
                {48.46f, 35.05f}, //Dnipro
                {48.27f, 35.03f}, // Dnipro, pr. Yavrnit, 22
                {50.45f, 30.52f}, // Kyiv
                {40.42f, 74.00f}, // New York
                {48.51f, 2.21f}, // Paris
                {35.41f, 139.41f}, // Tokyo
                {-15.78f, -47.93f}, // Brasilia
                {-35.28f, 149.12f}, // Canberra
        });
    }

    @Test
    @Parameters(method = "inputDataPositive")
    public void testEarthImagery(Float lat, Float lon) {
        try{
            Earth earth = new Earth();
            String response = earth.run(lat, lon);
            Parsing pars = new Parsing(EarthObject.class, response);
            EarthObject object = (EarthObject) pars.parseDataFromJson();
            String expected = "earth";
            Assert.assertEquals("Bad nasa.connection", expected, object.getResource().getPlanet());
        }catch (IOException e){
            Assert.fail(e.getMessage());
        }
    }
}

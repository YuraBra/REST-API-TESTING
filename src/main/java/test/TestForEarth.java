package test;

import Parsing.Parsing;
import connection.CME;
import connection.Earth;
import data.CMEObject;
import data.earthObject.EarthObject;
import data.marsRoverPhotos.PhotoMars;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class TestForEarth {
    private Float lon = -95.33f;
    private Float lat = 29.78f;


    @Test
    public void testEarthImagery() throws IOException {
        Earth earth = new Earth();
        String response = earth.run(lon, lat);
        Parsing pars = new Parsing(EarthObject.class, response);
        EarthObject object = (EarthObject)pars.parseDataFromJson();
        String expected = "earth";
        Assert.assertEquals("Bad connection", expected, object.getResource().getPlanet());
    }
}

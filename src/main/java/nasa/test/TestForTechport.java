package nasa.test;

import nasa.parsing.Parsing;
import nasa.services.Techport;
import nasa.data.techportObject.ListTechPortObjects;
import org.junit.Assert;
import org.junit.Test;
import scooter.test.BaseTest;

import java.io.IOException;

public class TestForTechport extends BaseTest {

    @Test
    public void testForTechport() throws IOException {

        String expected = "Development of Advanced Anti-Reflection Coatings for High Performance Solar Energy Applications, Phase II";

        Techport techport = new Techport();
        String response = techport.run();
        Parsing parsing = new Parsing(new ListTechPortObjects(), response);
        ListTechPortObjects techportObjects = (ListTechPortObjects) parsing.parseDataFromJson();

        Assert.assertEquals(expected,techportObjects.getProject().getTitle());
    }
}

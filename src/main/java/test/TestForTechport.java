package test;

import parsing.Parsing;
import connection.Techport;
import data.techportObject.ListTechPortObjects;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class TestForTechport {

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

package nasa.test;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import nasa.parsing.Parsing;
import nasa.connection.Techport;
import nasa.data.techportObject.ListTechPortObjects;
import nasa.testData.TechPortData;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.IOException;
import java.util.*;

@RunWith(JUnitParamsRunner.class)
public class TestForTechport {
    TechPortData techPortData;

    public static Collection<Object[]> inputData() {
        return Arrays.asList(new Object[][]{
                {TechPortData.id1,},
                {TechPortData.id2,},
                {TechPortData.id3,},
                {TechPortData.id4,}
        });
    }

    @Before
    public void beforeTestCreateExpectedData(){
        techPortData  = new TechPortData();
    }

    @Test
    @Parameters(method = "inputData")
    public void testForTechport(String id) throws IOException {
        String expected = techPortData.getTitle(id);
        Techport techport = new Techport(id);
        String response = techport.run();
        Parsing parsing = new Parsing(new ListTechPortObjects(), response);
        ListTechPortObjects techportObjects = (ListTechPortObjects) parsing.parseDataFromJson();
        Assert.assertEquals(expected,techportObjects.getProject().getTitle());
    }
}

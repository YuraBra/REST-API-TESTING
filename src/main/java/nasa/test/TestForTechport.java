package nasa.test;

import nasa.parsing.Parsing;
import nasa.connection.Techport;
import nasa.data.techportObject.ListTechPortObjects;
import nasa.testData.TechPortData;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.io.IOException;
import java.util.*;

@RunWith(value = Parameterized.class)
public class TestForTechport {
    private String id;
    private String expectedTitle;

    public TestForTechport(String id, String expectedTitle) {
        this.id = id;
        this.expectedTitle = expectedTitle;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {TechPortData.id1, TechPortData.title1},
                {TechPortData.id2, TechPortData.title2},
                {TechPortData.id3, TechPortData.title3},
                {TechPortData.id4, TechPortData.title4}
        });
    }


    @Test
    public void testForTechport() throws IOException {
        Techport techport = new Techport(id);
        String response = techport.run();
        Parsing parsing = new Parsing(new ListTechPortObjects(), response);
        ListTechPortObjects techportObjects = (ListTechPortObjects) parsing.parseDataFromJson();
        Assert.assertEquals(expectedTitle,techportObjects.getProject().getTitle());
    }
}

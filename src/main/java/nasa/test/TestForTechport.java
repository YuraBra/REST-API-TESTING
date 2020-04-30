package nasa.test;

import nasa.parsing.Parsing;
import nasa.data.techportObject.ListTechPortObjects;
import nasa.services.Techport;
import nasa.testData.TechPortData;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import scooter.test.BaseTest;

import java.io.IOException;
import java.util.*;

@RunWith(value = Parameterized.class)
public class TestForTechport extends BaseTest {
    private String id;
    private String expectedTitle;

    public TestForTechport(String id, String expectedTitle) {
        this.id = id;
        this.expectedTitle = expectedTitle;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {TechPortData.ID1, TechPortData.TITLE1},
                {TechPortData.ID2, TechPortData.TITLE2},
                {TechPortData.ID3, TechPortData.TITLE3},
                {TechPortData.ID4, TechPortData.TITLE4}
        });
    }


    @Test
    public void testForTechport() throws IOException {
        Techport techport = new Techport(id);
        String response = techport.run();
        Parsing parsing = new Parsing(new ListTechPortObjects(), response);
        ListTechPortObjects techportObjects = (ListTechPortObjects) parsing.parseDataFromJson();
        Assert.assertEquals(expectedTitle, techportObjects.getProject().getTitle());
    }
}

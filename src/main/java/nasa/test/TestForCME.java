package nasa.test;

import nasa.connection.CME;
import nasa.data.CMEObject;
import nasa.parsing.Parsing;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.List;


public class TestForCME {
    private String catalog = "SWRC_CATALOG";

    @Test
    public void testCME() {
        try {
            CME cme = new CME();
            String responseFirst = cme.run();
            CMEObject expected = new CMEObject(catalog);
            Parsing parsing = new Parsing(new CMEObject(), responseFirst);
            List<CMEObject> actual = (List<CMEObject>) parsing.parseDataListFromJson();
            for (CMEObject cmeObject : actual) {
                Assert.assertEquals(expected, cmeObject);
            }
        } catch (IOException e) {
            Assert.fail(e.getMessage());
        }
    }
}

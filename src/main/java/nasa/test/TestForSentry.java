package nasa.test;

import nasa.connection.Sentry;
import nasa.data.SentryObject;
import nasa.parsing.Parsing;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class TestForSentry {
    private String expected = "NASA/JPL Sentry Data API";

    @Test
    public void testForSentry() {
        try {
            Sentry sentry = new Sentry();
            String response = sentry.run();
            Parsing parsing = new Parsing(new SentryObject(), response);
            SentryObject object = (SentryObject) parsing.parseDataFromJson();
            Assert.assertEquals("Signature response invalid", expected, object.getSignature().getSource());
        } catch (IOException e) {
            Assert.fail(e.getMessage());
        }
    }
}

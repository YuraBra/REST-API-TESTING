package nasa.test;

import nasa.parsing.Parsing;
import nasa.connection.Sentry;
import nasa.data.SentryObject;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class TestForSentry {
    private String expected = "NASA/JPL Sentry Data API";

    @Test
    public void testForSentry() throws IOException {
        Sentry sentry = new Sentry();
        String response = sentry.run();
        Parsing parsing =  new Parsing(new SentryObject(), response);
        SentryObject object =(SentryObject)parsing.parseDataFromJson();
        Assert.assertEquals("Signature response invalid",expected, object.getSignature().getSource());
    }
}

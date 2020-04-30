package nasa.connection;

import okhttp3.Request;

import java.io.IOException;

public class Sentry extends BaseNasa {
    private String BaseSentryUrl;

    public Sentry() {
        this.BaseSentryUrl = "https://ssd-api.jpl.nasa.gov/sentry.api";
    }

    public String run() throws IOException {
        Request request = new Request.Builder()
                .url(BaseSentryUrl)
                .build();

        return getResponse(request);
    }
}

package connection;

import okhttp3.OkHttpClient;

public abstract class  BaseNasa {
    protected String baseUrl = "https://api.nasa.gov/";
    protected String apiKey = "dKdXfOjwdHsGDdwseYdttVZcYZyJswhL4o86prGk";
    protected OkHttpClient client;

    public BaseNasa() {
        this.client = new OkHttpClient();
    }
}

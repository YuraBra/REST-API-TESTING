package scooter.services;

import okhttp3.OkHttpClient;

public class BaseScooter {
    protected String baseUrl = "http://sslsecure.website/";
    protected OkHttpClient client;

    public BaseScooter() {
        this.client = new OkHttpClient();
    }
}
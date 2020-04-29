package scooter.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.Getter;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

import static scooter.util.JsonUtil.*;

public class RequestUtil {
    private static OkHttpClient requestClient = new OkHttpClient();
    private JsonUtil jsonUtil;
    @Getter
    private int responseCode;


    public Request getRequest(String httpUrl) {
        return new Request.Builder()
                .url(httpUrl)
                .get()
                .build();
    }

    public Request getRequest(String httpUrl, String token) {
        return new Request.Builder()
                .url(httpUrl)
                .addHeader("Authorization", "Bearer " + token)
                .get()
                .build();
    }

    public <T> Request postRequest(String httpUrl, T payload) throws JsonProcessingException {
        return new Request.Builder()
                .url(httpUrl)
                .post(createRequestBody(createJsonFromObject(payload)))
                .build();
    }

    public <T> Request postRequest(String httpUrl, T payload, String token) throws JsonProcessingException {
        return new Request.Builder()
                .url(httpUrl)
                .addHeader("Authorization", "Bearer " + token)
                .post(createRequestBody(createJsonFromObject(payload)))
                .build();
    }

    public <T> Request putRequest(String httpUrl, T payload) throws JsonProcessingException {
        return new Request.Builder()
                .url(httpUrl)
                .put(createRequestBody(createJsonFromObject(payload)))
                .build();
    }

    public <T> Request deleteRequest(String httpUrl, T payload) throws JsonProcessingException {
        return new Request.Builder()
                .url(httpUrl)
                .delete(createRequestBody(createJsonFromObject(payload)))
                .build();
    }

    public <T> Request deleteRequest(String httpUrl, String token) throws JsonProcessingException {
        return new Request.Builder()
                .url(httpUrl)
                .addHeader("Authorization", "Bearer " + token)
                .delete()
                .build();
    }

    public String getResponse(Request request) throws IOException {
        Response response = requestClient.newCall(request).execute();
        responseCode = response.code();
        return response.body().string();
    }

    public <T> T getResponseAs(Class<T> tClass, Request request) throws IOException {
        return createObjectFromJson(getResponse(request), tClass);
    }

}

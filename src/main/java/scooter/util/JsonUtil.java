package scooter.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.MediaType;
import okhttp3.RequestBody;

import java.lang.reflect.Type;

public class JsonUtil {
    private static final MediaType JSON = MediaType.get("application/json; charset=utf-8");

    public static RequestBody createRequestBody(String json) {
        return RequestBody.create(json, JSON);
    }

    public static String createJsonFromObject(Object o) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(o);
    }

    public static <T> T createObjectFromJson(String json, Class<T> tClass) throws JsonProcessingException {
        return new ObjectMapper().readValue(json, tClass);
    }

}

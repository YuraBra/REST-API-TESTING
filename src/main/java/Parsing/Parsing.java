package Parsing;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Parsing {
    private Object instance;
    private String response;


    public Parsing(Object instance, String response) {
        this.instance = instance;
        this.response = response;
    }

    public Object parseDataFromJson() throws JsonProcessingException {
        return new ObjectMapper().readValue(response, instance.getClass());
    }
    public Object parseDataFromJsonFailProperties() throws JsonProcessingException {
        return new ObjectMapper().disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES).readValue(response, instance.getClass());
    }
}
package Parsing;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Parsing {
    private Object instance;
    private String response;


    public Parsing(Object instance, String response) {
        this.instance = instance;
        this.response = response;
    }

    public Object parseDataFromJson() throws JsonProcessingException {
        return  new ObjectMapper().readValue(response, instance.getClass());
    }
}

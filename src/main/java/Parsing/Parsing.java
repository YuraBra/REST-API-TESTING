package Parsing;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import data.CMEObject;

import java.util.List;

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


    public Object parseDataListFromJson() throws JsonProcessingException {
        return new ObjectMapper().readValue(response, new TypeReference<List<CMEObject>>() {      });
    }
}

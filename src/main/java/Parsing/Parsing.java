package Parsing;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import data.CMEObject;

import java.util.List;

public class Parsing {
    private Object instance;
    private String response;
    private Class clazz;

    public Parsing(Object instance, String response) {
        this.instance = instance;
        this.response = response;
    }

    public Parsing(Class clazz, String response) {
        this.clazz = clazz;
        this.response = response;
    }

    public Object parseDataFromJson() throws JsonProcessingException {
        if (instance != null) {
            clazz = instance.getClass();
        }
        return new ObjectMapper().readValue(response, clazz);
    }


    public Object parseDataListFromJson() throws JsonProcessingException {
        return new ObjectMapper().readValue(response, new TypeReference<List<CMEObject>>() {
        });

    }

    public Object parseDataFromJsonFailProperties() throws JsonProcessingException {
        if (instance != null) {
            clazz = instance.getClass();
        }
        return new ObjectMapper().readValue(response, clazz);
    }
}
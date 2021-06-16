package com.example.dia3springboot.writter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonWritter implements Writter{
    @Override
    public <M> byte[] write(M m) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.writeValueAsBytes(m);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}

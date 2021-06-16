package com.example.dia3springboot.entity;

import java.util.HashMap;
import java.util.Map;

public class NullBaseMetaData implements BaseMateData{
    @Override
    public Map<String, String> getProperties() {
        return new HashMap<>(0);
    }
}

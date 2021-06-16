package com.example.dia3springboot.reader;

import org.apache.tika.metadata.Metadata;

public class NullReader implements Reader{
    @Override
    public Metadata read(String path) {
        return new Metadata();
    }
}

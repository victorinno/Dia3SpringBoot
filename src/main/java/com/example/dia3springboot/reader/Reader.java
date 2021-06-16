package com.example.dia3springboot.reader;

import org.apache.tika.metadata.Metadata;

public interface Reader {

    Metadata read(String path);
}

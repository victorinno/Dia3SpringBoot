package com.example.dia3springboot.perssiter;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;

public class JsonPersister implements Persister{
    @Override
    public void persist(byte[] data, String path) {
        try {
            FileUtils.writeByteArrayToFile(new File(path), data);
        } catch (IOException e) {
            System.out.println("An error occurred.");
            throw new RuntimeException(e);
        }
    }
}

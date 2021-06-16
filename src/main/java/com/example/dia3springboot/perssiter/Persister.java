package com.example.dia3springboot.perssiter;

public interface Persister {

    void persist(byte[] data, String path);

}

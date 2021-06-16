package com.example.dia3springboot.encrypter;

public class NullEncrypter implements Encrypter{
    @Override
    public byte[] encrypt(byte[] data) {
        return data;
    }
}

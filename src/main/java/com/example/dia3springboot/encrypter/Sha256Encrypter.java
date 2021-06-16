package com.example.dia3springboot.encrypter;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Sha256Encrypter implements Encrypter {
    @Override
    public byte[] encrypt(byte[] data) {
        MessageDigest digest = null;
        try {
            digest = MessageDigest.getInstance("SHA-256");
            return digest.digest(data);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}

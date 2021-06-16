package com.example.dia3springboot.encrypter;

public enum Encrypters {
    SHA256("SHA-256");

    private String type;

    Encrypters(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}

package com.example.dia3springboot.encrypter;

public class FactoryEncrypter {

    public static Encrypter createEncrypter(Encrypters type){
        switch (type){
            case SHA256:
                return new Sha256Encrypter();
            default:
                return new NullEncrypter();
        }
    }
}

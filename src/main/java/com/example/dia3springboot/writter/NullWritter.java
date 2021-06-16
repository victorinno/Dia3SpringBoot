package com.example.dia3springboot.writter;

import com.example.dia3springboot.entity.NullBaseMetaData;

public class NullWritter implements Writter{

    @Override
    public <M> byte[] write(M m) {
        return new byte[0];
    }
}

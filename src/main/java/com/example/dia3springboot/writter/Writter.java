package com.example.dia3springboot.writter;

import com.example.dia3springboot.entity.BaseMateData;

public interface Writter {

    <M> byte[] write(M m);
}

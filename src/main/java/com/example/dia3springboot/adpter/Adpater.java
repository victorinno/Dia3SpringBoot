package com.example.dia3springboot.adpter;

import com.example.dia3springboot.entity.BaseMateData;
import org.apache.tika.metadata.Metadata;

public interface Adpater<B extends BaseMateData> {
    B convert(Metadata a);
}

package com.example.dia3springboot.adpter;

import com.example.dia3springboot.entity.NullBaseMetaData;
import org.apache.tika.metadata.Metadata;

public class NullAdpater implements Adpater<NullBaseMetaData>{
    @Override
    public NullBaseMetaData convert(Metadata o) {
        return new NullBaseMetaData();
    }
}

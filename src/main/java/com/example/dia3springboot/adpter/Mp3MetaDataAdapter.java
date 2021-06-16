package com.example.dia3springboot.adpter;

import com.example.dia3springboot.entity.Mp3MetaData;
import org.apache.tika.metadata.Metadata;

public class Mp3MetaDataAdapter implements Adpater<Mp3MetaData> {
    @Override
    public Mp3MetaData convert(Metadata metadata) {
        return Mp3MetaData.builder()
                .album(metadata.get("xmpDM:album"))
                .artists(metadata.get("xmpDM:artist"))
                .comment(metadata.get("xmpDM:logComment"))
                .genre(metadata.get("xmpDM:genre"))
                .header("TAG")
                .title(metadata.get("title"))
                .year(metadata.get("xmpDM:releaseDate"))
                .build();
    }
}

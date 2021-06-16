package com.example.dia3springboot.service;

import com.example.dia3springboot.adpter.Adpater;
import com.example.dia3springboot.encrypter.Encrypter;
import com.example.dia3springboot.entity.BaseMateData;
import com.example.dia3springboot.perssiter.Persister;
import com.example.dia3springboot.reader.Reader;
import com.example.dia3springboot.writter.Writter;
import lombok.Builder;
import lombok.Setter;
import org.apache.tika.metadata.Metadata;
import org.springframework.data.jpa.repository.JpaRepository;

@Builder
@Setter
public class BaseService {

    private Reader reader;

    private Encrypter encrypter;

    private Persister persister;

    public <B extends BaseMateData> void execute(
            String path,
            String target,
            Adpater<B> adapter,
            Writter writter,
            JpaRepository<B, Long> dao
    ) {
        Metadata metadata = reader.read(path);
        B convertedMetaData = adapter.convert(metadata);
        convertedMetaData = dao.saveAndFlush(convertedMetaData);
        byte[] data = writter.write(convertedMetaData);
        byte[] encryptedData = encrypter.encrypt(data);
        persister.persist(encryptedData, target);
    }

}

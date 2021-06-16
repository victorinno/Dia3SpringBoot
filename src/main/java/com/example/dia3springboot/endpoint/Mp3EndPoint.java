package com.example.dia3springboot.endpoint;

import com.example.dia3springboot.adpter.Mp3MetaDataAdapter;
import com.example.dia3springboot.encrypter.Encrypters;
import com.example.dia3springboot.encrypter.FactoryEncrypter;
import com.example.dia3springboot.encrypter.NullEncrypter;
import com.example.dia3springboot.perssiter.AsyncPersisterDecorator;
import com.example.dia3springboot.perssiter.JsonPersister;
import com.example.dia3springboot.reader.Mp3Reader;
import com.example.dia3springboot.repository.Mp3MetaDataRepository;
import com.example.dia3springboot.service.BaseService;
import com.example.dia3springboot.writter.JsonWritter;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.core.Response;

@RestController()
public class Mp3EndPoint {

    private final Mp3Reader reader;
    private Mp3MetaDataRepository mp3MetaDataRepository;
    private Mp3MetaDataAdapter adapter;

    public Mp3EndPoint(Mp3MetaDataRepository mp3MetaDataRepository) {
        this.mp3MetaDataRepository = mp3MetaDataRepository;
        this.adapter = new Mp3MetaDataAdapter();
        this.reader = new Mp3Reader();
    }

    @PostMapping("/mp3")
    public Response gravarJson(@RequestBody PathsParameters pathsParameters) {
        BaseService service = BaseService.builder()
                .encrypter(new NullEncrypter())
                .reader(reader)
                .persister(new JsonPersister()).build();
        service.execute(pathsParameters.getPath(), pathsParameters.getTarget(), adapter, new JsonWritter(), mp3MetaDataRepository);
        return Response.ok().build();
    }

    @PostMapping("/mp3/{encrypt}/{async}")
    public Response gravarJson(@RequestBody PathsParameters pathsParameters, @PathVariable Encrypters encrypt, @PathVariable Boolean async) {
        BaseService service = BaseService.builder()
                .encrypter(FactoryEncrypter.createEncrypter(encrypt))
                .reader(reader)
                .persister(async ? new AsyncPersisterDecorator(new JsonPersister()) : new JsonPersister()).build();
        adapter = new Mp3MetaDataAdapter();
        service.execute(pathsParameters.getPath(), pathsParameters.getTarget(), adapter, new JsonWritter(), mp3MetaDataRepository);
        return Response.ok().build();
    }

}

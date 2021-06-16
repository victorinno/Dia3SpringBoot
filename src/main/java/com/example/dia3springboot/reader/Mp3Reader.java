package com.example.dia3springboot.reader;

import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.mp3.Mp3Parser;
import org.apache.tika.sax.BodyContentHandler;
import org.xml.sax.SAXException;

import java.io.FileInputStream;
import java.io.IOException;

public class Mp3Reader implements Reader {

    @Override
    public Metadata read(String path) {
        try {
            BodyContentHandler handler = new BodyContentHandler();
            Metadata metadata = new Metadata();
            FileInputStream inputstream = new FileInputStream(path);
            ParseContext pcontext = new ParseContext();
            Mp3Parser Mp3Parser = new Mp3Parser();
            Mp3Parser.parse(inputstream, handler, metadata, pcontext);
            return metadata;
        } catch (TikaException | IOException | SAXException e) {
            throw new RuntimeException(e);
        }
    }
}

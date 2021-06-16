package com.example.dia3springboot.repository;

import com.example.dia3springboot.entity.Mp3MetaData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Mp3MetaDataRepository extends JpaRepository<Mp3MetaData, Long> {

    List<Mp3MetaData> findByGenre(Byte genre);
}

package com.murang.rental.data.repository;

import com.murang.rental.data.entity.Articles;
import com.murang.rental.data.entity.Locations;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LocationRepository extends JpaRepository<Locations, Integer> {

    @Query()
    List<Articles> findAllByLocation(String sido, String sigungu, String bname);
}

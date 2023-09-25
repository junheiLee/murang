package com.murang.rental.data.repository;

import com.murang.rental.data.entity.Locations;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Locations, Integer> {

//    @Query()
//    List<Articles> findAllByLocation(String sido, String sigungu, String bname);
}

package com.murang.rental.data.repository;

import com.murang.rental.data.entity.Articles;
import com.murang.rental.data.entity.Category;
import com.murang.rental.data.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ArticlesRepository extends JpaRepository<Articles,Integer> {

    @Query(value = "select * from articles where articles.location.sido=?1")
    List<Articles> findAllByLocation(String sido);
    List<Articles> findByCategory(Category category);
}

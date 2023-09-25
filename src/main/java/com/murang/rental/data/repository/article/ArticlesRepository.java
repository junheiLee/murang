package com.murang.rental.data.repository.article;

import com.murang.rental.data.entity.Articles;
import com.murang.rental.data.entity.Category;
import com.murang.rental.data.entity.User;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ArticlesRepository extends JpaRepository<Articles,Integer>  {

    List<Articles> findAllByCategory(Category category);

    @EntityGraph(attributePaths = {"makenArticlesList"})
    List<Articles> findByUserId(@Param("user_id") String userId);

//    @Query(value = "select * from articles where articles.location.sido=?1")
//    List<Articles> findAllByLocation(String sido);
//    List<Articles> findByCategory(Category category);
}

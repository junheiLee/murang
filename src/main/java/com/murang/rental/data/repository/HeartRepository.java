package com.murang.rental.data.repository;

import com.murang.rental.data.entity.HeartArticle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface HeartRepository extends JpaRepository<HeartArticle, Integer> {
    public Optional<HeartArticle> findByUserIdAndArticleId(String userId, Integer articleId);
    public void deleteByUserIdAndArticleId(String userId, Integer articleId);
    public List<HeartArticle> findAllByUserId(String userId);

    Long countByUserId(String userId);
}
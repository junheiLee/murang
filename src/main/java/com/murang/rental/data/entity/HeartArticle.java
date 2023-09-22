package com.murang.rental.data.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
public class HeartArticle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String userId;

    private Integer articleId;

    public HeartArticle(String userId, Integer articleId) {
        this.userId = userId;
        this.articleId = articleId;
    }
}

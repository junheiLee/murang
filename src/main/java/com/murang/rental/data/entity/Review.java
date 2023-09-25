package com.murang.rental.data.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "reviews")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer reviewId;

    @ManyToOne
    @JoinColumn(name = "writer_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "articles_id")
    private Articles articles;

    private String comments;

    private int rating;


//    public Review(ReviewRequestDto reviewRequestDto) {
//        this.
//    }
}
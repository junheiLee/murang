package com.murang.rental.data.dto.review;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ReviewRequestDto {

    private Integer writerId;
    private Integer articlesId;
    private String comments;
    private Integer rating;


    public Integer getWriterId() {
        return this.writerId;
    }

    public Integer getArticlesId() {
        return this.articlesId;
    }

    public String getComments() {
        return this.comments;
    }

    public Integer getRating() {
        return this.rating;
    }


    public void setWriterId(Integer writerId) {
        this.writerId = writerId;
    }

    public void setArticlesId(Integer articlesId) {
        this.articlesId = articlesId;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }
}
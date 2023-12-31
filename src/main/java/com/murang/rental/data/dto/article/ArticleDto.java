package com.murang.rental.data.dto.article;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@Builder
public class ArticleDto {

    private Integer id;

    private String title;

    private LocalDateTime publishDay;

    private Integer stock;

    private Integer price;

    private String userId;

    private Double userGrade;

    private Integer period;

    private String description;

    private boolean status;
}

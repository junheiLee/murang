package com.murang.rental.data.dto;

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

    private Integer period;

    private Integer status;

    private String description;

    private boolean heart;

}

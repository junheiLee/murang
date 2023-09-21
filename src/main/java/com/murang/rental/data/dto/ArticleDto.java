package com.murang.rental.data.dto;

import lombok.Builder;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;

@Data
public class ArticleDto {

    private String title;

    private Integer stock;

    private Integer price;

    private Integer period;

    private String description;

    private boolean articleDelete;

    @Builder
    public ArticleDto(String title, LocalDateTime publishDay, Integer stock, Integer price, Integer period, String description, boolean articleDelete) {
        this.title = title;
        this.stock = stock;
        this.price = price;
        this.period = period;
        this.description = description;
        this.articleDelete = articleDelete;
    }
}

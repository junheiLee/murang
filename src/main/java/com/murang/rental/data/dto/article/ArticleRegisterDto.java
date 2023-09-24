package com.murang.rental.data.dto.article;

import com.murang.rental.data.entity.Category;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@Builder
public class ArticleRegisterDto {

    private Integer id;

    private String title;

    private LocalDateTime publishDay;

    private Integer stock;

    private Integer price;

    private Integer period;

    private String description;

    private boolean status;

    private Category category;

    //location 정보
    private String sido;

    private String sigugun;

    private String bname;

}

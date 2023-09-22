package com.murang.rental.data.entity;

import com.murang.rental.data.dto.ArticleDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Articles {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer articleId;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private LocalDateTime publishDay;

    @Column(nullable = false)
    private Integer stock;

    private Integer price;

    private Integer period;

    private Integer status;

    private String filePath;

    private String description;

    private boolean heart;

    private boolean articleDelete;

    private boolean mine;

    @ManyToOne
    @ToString.Exclude
    private User user;

    @ManyToOne
    @ToString.Exclude
    private Categories category;

    @OneToOne
    private Locations location;

    public Articles(ArticleDto articleDto) {
        this.title = articleDto.getTitle();
        this.publishDay = articleDto.getPublishDay();
        this.stock = articleDto.getStock();
        this.price = articleDto.getPrice();
        this.period = articleDto.getPeriod();
        this.status = articleDto.getStatus();
        this.description = articleDto.getDescription();
        this.heart = articleDto.isHeart();
    }

    public static ArticleDto articleFactory(Articles articles) {
        return ArticleDto.builder()
                .title(articles.getTitle())
                .publishDay(articles.getPublishDay())
                .stock(articles.getStock())
                .price(articles.getPrice())
                .period(articles.getPeriod())
                .status(articles.getStatus())
                .description(articles.getDescription())
                .heart(articles.isHeart())
                .build();
    }
}

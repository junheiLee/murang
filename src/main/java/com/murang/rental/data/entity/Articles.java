package com.murang.rental.data.entity;

import com.murang.rental.data.dto.ArticleDto;
import com.murang.rental.data.dto.ArticleRegisterDto;
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

    private String filePath;

    private String description;

    private boolean articleDelete;

    private boolean mine;

    private boolean status;

    @ManyToOne
    @ToString.Exclude
    private User user;

    @Enumerated(EnumType.STRING)
    private Category category;

    @OneToOne(cascade = CascadeType.ALL)
    private Locations location;

    public Articles(ArticleRegisterDto articleRegisterDto) {
        this.title = articleRegisterDto.getTitle();
        this.publishDay = articleRegisterDto.getPublishDay();
        this.stock = articleRegisterDto.getStock();
        this.price = articleRegisterDto.getPrice();
        this.period = articleRegisterDto.getPeriod();
        this.description = articleRegisterDto.getDescription();
        this.category = articleRegisterDto.getCategory();

        this.location = new Locations(articleRegisterDto);
    }

    public static ArticleDto articleFactory(Articles articles) {
        return ArticleDto.builder()
                .id(articles.getArticleId())
                .title(articles.getTitle())
                .publishDay(articles.getPublishDay())
                .stock(articles.getStock())
                .price(articles.getPrice())
                .period(articles.getPeriod())
                .description(articles.getDescription())
                .status(articles.isStatus())
                .build();
    }
}

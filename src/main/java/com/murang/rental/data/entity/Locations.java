package com.murang.rental.data.entity;

import com.murang.rental.data.dto.LocationDto;
import com.murang.rental.data.dto.article.ArticleRegisterDto;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Locations {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer locationId;

    private String sido;
    private String sigugun;
    private String bname;

    public Locations(LocationDto locationDto) {
        this.sido = locationDto.getSido();
        this.sigugun = locationDto.getSigugun();
        this.bname = locationDto.getBname();
    }
}

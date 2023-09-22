package com.murang.rental.data.entity;

import com.murang.rental.data.dto.ArticleRegisterDto;
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

    public Locations(ArticleRegisterDto articleRegisterDto) {
        this.sido = articleRegisterDto.getSido();
        this.sigugun = articleRegisterDto.getSigugun();
        this.bname = articleRegisterDto.getBname();
    }
}

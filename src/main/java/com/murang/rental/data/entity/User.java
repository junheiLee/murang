package com.murang.rental.data.entity;

import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer num;

    @Column(unique = true)
    private String userId;

    @Column(nullable = false)
    private String password;

    @ColumnDefault("3")
    private int grade;

    @ColumnDefault("1")
    private int member_status;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String nickname;

    @OneToOne
    private Locations locations;

    @OneToMany
    private List<Articles> rentArticlesList = new ArrayList<>();
}

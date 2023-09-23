package com.murang.rental.data.entity;

import com.murang.rental.data.dto.UserDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user")
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer num;

    @Column(unique = true, nullable = false)
    private String id;

    @Column(nullable = false)
    private String password;

    @ColumnDefault("3")
    @Column(insertable = false)
    private Double grade;

    @ColumnDefault("1")
    @Column(insertable = false)
    private int member_status;

    @Column(nullable = false)
    private String name;

//    @Column(nullable = false)
//    private String nickname;

    @OneToOne
    private Locations locations;

    @OneToMany
    private List<Articles> makenArticlesList = new ArrayList<>();

    @OneToMany
    private List<Articles> rentArticlesList = new ArrayList<>();


    public User(UserDto userDto) {
        this.id = userDto.getId();
        this.password = userDto.getPassword();
        this.name = userDto.getName();
        this.grade = userDto.getGrade();
    }


}
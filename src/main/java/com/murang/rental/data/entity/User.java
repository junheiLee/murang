package com.murang.rental.data.entity;

import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user")
public class User {

    @Id
    private String id;

    @Column(nullable = false)
    private String password;

    @ColumnDefault("3")
    @Column(insertable=false)
    private Integer grade;

    @ColumnDefault("1")
    @Column(insertable=false)
    private Integer member_status;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String birth;

    @Column(nullable = false)
    private String location;

    public User(String id, String password, String name, String birth, String location) {
        this.id = id;
        this.password = password;
        this.name = name;
        this.birth = birth;
        this.location = location;
    }
}

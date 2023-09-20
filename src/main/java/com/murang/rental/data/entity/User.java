package com.murang.rental.data.entity;

import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name ="user")
public class User{

    @Id
    private String id;

    @Column(nullable = false)
    private String password;

    @ColumnDefault("3")
    private int grade;

    @ColumnDefault("1")
    private  int member_status;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Date birth;

    @Column(nullable = false)
    private String location;





}

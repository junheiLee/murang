package com.murang.rental.data.entity;

import com.murang.rental.data.dto.UserDto;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
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

    @ColumnDefault("2.5")
    @Column(insertable=false)
    private Double grade;

    @ColumnDefault("1")
    @Column(insertable=false)
    private Integer member_status;

    @Column(nullable = false)
    private String name;

    private String profileImage;

    @Column(nullable = false)
//    @OneToOne
    private String location;


    public User(UserDto userDto) {
        this.id = userDto.getId();
        this.password = userDto.getPassword();
        this.name = userDto.getName();
        this.location = userDto.getLocation();
        this.grade = userDto.getGrade();
        this.member_status = userDto.getMember_status();
    }




}

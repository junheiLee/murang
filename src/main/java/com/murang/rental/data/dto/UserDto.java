package com.murang.rental.data.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class UserDto {

    private String id;
    private String password;
    private String name;
    private Double grade;
    private Integer member_status;
    private String location;
}

package com.murang.rental.data.dto.user;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {

    private String userId;
    private String password;
    private String name;
    private Double grade;
    private Integer member_status;
    private String location;
}

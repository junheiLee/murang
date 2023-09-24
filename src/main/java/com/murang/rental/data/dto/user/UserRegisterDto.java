package com.murang.rental.data.dto.user;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class UserRegisterDto {

    private String userId;
    private String password;
    private String name;
    private Double grade;
    private Integer member_status;
    private String sido;
    private String sigungu;
    private String bname;
}

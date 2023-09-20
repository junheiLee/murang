package com.murang.rental.service;


import com.murang.rental.data.dto.UserDto;
import com.murang.rental.data.entity.User;

public interface UserService {

     void insertUser(UserDto userDto);
     boolean isDuplicate(String id);

}

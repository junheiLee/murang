package com.murang.rental.service;


import com.murang.rental.data.dto.UserDto;
import com.murang.rental.data.entity.User;

import java.util.Optional;

public interface UserService {

     void insertUser(UserDto userDto);
     String isDuplicate(String id);

     User findUserById(String id);

}

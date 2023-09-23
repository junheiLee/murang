package com.murang.rental.service;


import com.murang.rental.data.dto.LoginDto;
import com.murang.rental.data.dto.UserDto;
import com.murang.rental.data.entity.User;

import javax.servlet.http.HttpSession;

public interface UserService {

    void insertUser(UserDto userDto);

    String isDuplicate(String id);

    User findUserById(String id);

    String loginCheck(LoginDto loginDto, HttpSession session);
}

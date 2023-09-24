package com.murang.rental.service;


import com.murang.rental.data.dto.user.LoginDto;
import com.murang.rental.data.dto.user.UserDto;
import com.murang.rental.data.dto.user.UserRegisterDto;
import com.murang.rental.data.entity.User;

import javax.servlet.http.HttpSession;

public interface UserService {

    void insertUser(UserRegisterDto userRegisterDto);

    String isDuplicate(String id);

    User findUserById(String id);

    String loginCheck(LoginDto loginDto, HttpSession session);
}

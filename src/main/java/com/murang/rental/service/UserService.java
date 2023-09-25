package com.murang.rental.service;


import com.murang.rental.data.dto.article.ArticleDto;
import com.murang.rental.data.dto.user.LoginDto;
import com.murang.rental.data.dto.user.UserRegisterDto;
import com.murang.rental.data.entity.Articles;
import com.murang.rental.data.entity.User;

import javax.servlet.http.HttpSession;
import java.util.List;

public interface UserService {

    void insertUser(UserRegisterDto userRegisterDto);

    String isDuplicate(String id);

    User findUserById(String id);

    String loginCheck(LoginDto loginDto, HttpSession session);

    public List<Articles> findRentalList(String userId);

    public List<Articles> findHeartList(String userId);



}

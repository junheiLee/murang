package com.murang.rental.service;

import com.murang.rental.data.entity.User;
import com.murang.rental.data.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

 private final UserRepository userRepository;

 /**
  * 회원가입 메서드
  * @param 회원정보 entity
  */
 @Transactional
 @Override
 public User insertUser(User user) {
  return null;
 }


}

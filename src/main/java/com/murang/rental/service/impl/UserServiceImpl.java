package com.murang.rental.service.impl;

import com.murang.rental.data.dto.UserDto;
import com.murang.rental.data.entity.User;
import com.murang.rental.data.repository.UserRepository;
import com.murang.rental.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    /**
     * 회원가입 메서드
     *
     * @Param user entity
     */
    @Override
    public void insertUser(UserDto userDto) {

        User user = new User(userDto);
        userRepository.save(user);

    }

    @Override
    public String isDuplicate(String id) {
        System.out.println("서비스");
        if(userRepository.existsUserById(id)){
            return "중복 아이디 입니당";
        }else{
            return "사용가능한 아이디 입니당";
        }

    }

    public User findUserById(String id){
        return userRepository.findUserById(id).get();
    }


}

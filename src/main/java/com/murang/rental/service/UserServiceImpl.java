package com.murang.rental.service;

import com.murang.rental.data.dto.UserDto;
import com.murang.rental.data.entity.User;
import com.murang.rental.data.repository.UserRepository;
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
        if(userRepository.existsById(id)){
            return "중복 아이디 입니당";
        }else{
            return "사용가능한 아이디 입니당";
        }

    }

    public User findById(String id){
        return userRepository.findById(id).get();
    }


}

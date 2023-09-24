package com.murang.rental.service.impl;

import com.murang.rental.data.dto.user.LoginDto;
import com.murang.rental.data.dto.user.UserDto;
import com.murang.rental.data.dto.user.UserRegisterDto;
import com.murang.rental.data.entity.User;
import com.murang.rental.data.repository.UserRepository;
import com.murang.rental.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
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
    public void insertUser(UserRegisterDto userRegisterDto) {

        User user = new User(userRegisterDto);
        userRepository.save(user);

    }

    @Override
    public String isDuplicate(String id) {
        if(userRepository.existsByUserId(id)){
            return "중복 아이디 입니당";
        }else{
            return "사용가능한 아이디 입니당";
        }

    }

    public User findUserById(String id){
        return userRepository.findByUserId(id).get();
    }

    public String loginCheck(LoginDto loginDto, HttpSession session){
        Optional<User> user = userRepository.findByUserIdAndPassword(loginDto.getUserId(), loginDto.getPassword());
        if(user.isPresent()){
            session.setAttribute("userId", loginDto.getUserId());
            return "redirect:/articles";
        } else{
            return "loginError";
        }
    }
}

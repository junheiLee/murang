package com.murang.rental.service;

import com.murang.rental.data.dto.UserDto;
import com.murang.rental.data.entity.User;
import com.murang.rental.data.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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
        User user = new User(userDto.getId(),userDto.getPassword(),userDto.getName(),userDto.getBirth(),userDto.getLocation());

        userRepository.save(user);
    }

    @Override
    public boolean isDuplicate(String id) {
        return userRepository.existsById(id);
    }


}

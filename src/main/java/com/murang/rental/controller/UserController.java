package com.murang.rental.controller;

import com.murang.rental.data.dto.UserDto;
import com.murang.rental.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/login")
    public String login() {
        return "/login";
    }

    @PostMapping("/join")
    public String join(UserDto userDto) {

        userService.insertUser(userDto);
        return "test";
    }


    @GetMapping("/check/{id}")
    @ResponseBody
    public String checkID(@PathVariable String id){
       if(userService.isDuplicate(id)){
           return "중복 아이디 입니당";
       }else{
           return "사용가능한 아이디 입니당";
       }
       
    }

}

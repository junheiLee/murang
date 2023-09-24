package com.murang.rental.controller;

import com.murang.rental.data.dto.user.LoginDto;
import com.murang.rental.data.dto.user.UserDto;
import com.murang.rental.data.dto.user.UserRegisterDto;
import com.murang.rental.data.entity.User;
import com.murang.rental.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @GetMapping("/mypage")
    public String mypage(HttpSession session, Model model) {
        String id = (String) session.getAttribute("userId");
        if (id != null) {
            User user = userService.findUserById(id);
            model.addAttribute("user", user);
            return "mypage";
        } else {
            return "login";
        }

    }

    @GetMapping("/loginform")
    public String loginForm(){
        return "login";
    }
    @PostMapping("/join")
    public String join(UserRegisterDto userRegisterDto) {
        userService.insertUser(userRegisterDto);
        return "index";
    }

    @GetMapping("/check/{id}")
    @ResponseBody
    public String checkID(@PathVariable String id) {
        return userService.isDuplicate(id);
    }

    @PostMapping("/loginCheck")
    private String loginCheck(@ModelAttribute LoginDto loginDto, HttpSession session) {
        return userService.loginCheck(loginDto, session);
    }

    @GetMapping("/logout")
    private String logout(HttpSession session) {
        session.invalidate();
        return "index";
    }

    @ResponseBody
    @GetMapping("/makenProduct")
    public List<String> makenProduct() {
        List<String> test = new ArrayList<>();

        test.add("hi2");
        test.add("hi3");
        test.add("hi4");
        test.add("hi5");

        return test;
    }

    @ResponseBody
    @GetMapping("/rentProduct")
    public List<String> rentProduct() {
        List<String> test = new ArrayList<>();

        test.add("hii6");
        test.add("hii7");
        test.add("hii8");
        test.add("hii9");

        return test;
    }

    @ResponseBody
    @GetMapping("/likeProduct")
    public List<String> likeProduct() {
        List<String> test = new ArrayList<>();

        test.add("hiii2");
        test.add("hiii3");
        test.add("hiii4");
        test.add("hiii5");

        return test;
    }

    @ResponseBody
    @GetMapping("/completeProduct")
    public List<String> completeProduct() {
        List<String> test = new ArrayList<>();

        test.add("hisss2");
        test.add("hisss3");
        test.add("hisss4");
        test.add("hisss5");

        return test;
    }

}

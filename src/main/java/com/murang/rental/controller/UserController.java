package com.murang.rental.controller;

import com.murang.rental.data.dto.UserDto;
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
        session.setAttribute("id", "test");
        String id = (String) session.getAttribute("id");
        if (id != null) {
           User user = userService.findUserById(id);
           model.addAttribute("user",user);
            System.out.println(user.getGrade());
            return "mypage";
        } else {
            return "mypage";        //수정필요 login페이지로
        }

    }

    @PostMapping("/join")
    public String join(UserDto userDto) {
        userService.insertUser(userDto);
        return "test";
    }

    @GetMapping("/check/{id}")
    @ResponseBody
    public String checkID(@PathVariable String id) {
        System.out.println("컨트롤러");
        return userService.isDuplicate(id);
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

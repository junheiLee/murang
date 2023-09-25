package com.murang.rental.controller;

import com.murang.rental.service.ReviewService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Slf4j
@RequiredArgsConstructor
@Controller
@RequestMapping("/reviews")
public class ReviewController {

    private final ReviewService reviewService;

    @GetMapping("/new")
    public String newReviewForm(HttpSession session) {
        if (session.getAttribute("userId") != null) {
            return "reviews/form";
        }else{
            return "login";
        }
    }
//
//    @PostMapping("/new")
//    public String registerReview(@ModelAttribute ReviewRequestDto reviewRequestDto) {
//        reviewService.insert(reviewRequestDto);
//        return "redirect:/";
//    }
}

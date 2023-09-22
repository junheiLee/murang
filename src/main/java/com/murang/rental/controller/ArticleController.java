package com.murang.rental.controller;

import com.murang.rental.data.dto.ArticleDto;
import com.murang.rental.data.entity.Articles;
import com.murang.rental.service.ArticleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/articles")
@Slf4j
public class ArticleController {

    ArticleService articleService;

    @Autowired
    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    /**
     * 상품 등록 페이지로 가는 mapping
     *
     * @return 상품 등록 페이지
     */
    @GetMapping("/screen")
    public String makeScreen(HttpSession session) {
        session.setAttribute("userId", "123");
        return "articles/screen";
    }

    /**
     * 상품 목록 페이지
     *
     * @param model articleList
     * @return 상품 목록
     */
    @GetMapping
    public String articleList(Model model) {
        model.addAttribute("articlesList", articleService.articleList());
        return "articles/list";
    }

    /**
     * 상품 등록 로직이 들어있음
     *
     * @param articleDto 상품 정보
     * @param image      상품 이미지
     * @return 상품 목록 API
     * @throws IOException
     */
    @PostMapping
    public String makeArticle(@ModelAttribute ArticleDto articleDto, @RequestParam MultipartFile image) throws IOException {
        articleService.insertArticle(articleDto, image);
        return "redirect:/articles";
    }

    @GetMapping("/{id}")
    public String detailArticle(HttpSession session, @PathVariable Integer id, Model model) {
        Map<String, Object> detailArticle = articleService.detailArticle(id);
        boolean heartDto = articleService.heartArticleSearch((String) session.getAttribute("userId"), id);
        model.addAttribute("heartDto", heartDto);
        model.addAttribute("articleDto", (ArticleDto) detailArticle.get("articleDto"));
        model.addAttribute("filePath", (String) detailArticle.get("filePath"));
        return "articles/detail";
    }

    @GetMapping("/like/{articleId}")
    public String likeArticle(HttpSession session, @PathVariable Integer articleId) {
        articleService.heartArticle((String) session.getAttribute("userId"), articleId);
        return "redirect:/articles/" + articleId.toString();
    }

    @GetMapping("/cancelLike/{articleId}")
    public String cancelHeart(HttpSession session, @PathVariable Integer articleId) {
        articleService.heartArticleDelete((String) session.getAttribute("userId"), articleId);
        return "redirect:/articles/" + articleId.toString();
    }

    @GetMapping("/rentals/{articleId}")
    public String rentalArticle(HttpSession session, @PathVariable Integer articleId) {
        articleService.rentalArticle((String) session.getAttribute("userId"), articleId);
        return "redirect:/articles/rentals";
    }

    @GetMapping("/rentals")
    public String rentalArticleList(HttpSession session, Model model) {
        List<Articles> rentalArticleList = articleService.rentalArticleList((String) session.getAttribute("userId"));
        model.addAttribute("rentalArticleList", rentalArticleList);
        return "/articles/rentals";
    }
}

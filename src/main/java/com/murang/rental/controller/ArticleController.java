package com.murang.rental.controller;

import com.murang.rental.data.dto.ArticleDto;
import com.murang.rental.service.ArticleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
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
    public String makeScreen(HttpServletRequest request) {
        HttpSession session = request.getSession();
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
    public String detailArticle(@PathVariable Integer id, Model model) {
        Map<String, Object> detailArticle = articleService.detailArticle(id);
        model.addAttribute("articleDto", (ArticleDto) detailArticle.get("articleDto"));
        model.addAttribute("filePath", (String) detailArticle.get("filePath"));
        return "articles/detail";
    }

    @GetMapping("/like")
    public String likeArticle(@RequestParam Integer id, Model model) {
        articleService.detailArticle(id);
        Map<String, Object> detailArticle = articleService.detailArticle(id);
        model.addAttribute("articleDto", (ArticleDto) detailArticle.get("articleDto"));
        model.addAttribute("filePath", (String) detailArticle.get("filePath"));
        return "articles/detail";
    }
}

package com.murang.rental.controller;

import com.murang.rental.data.dto.ArticleDto;
import com.murang.rental.service.ArticleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Controller
@RequestMapping("/articles")
@Slf4j
public class ArticleController {

    ArticleService articleService;

    @Autowired
    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @GetMapping("/screen")
    public String makeScreen() {
        return "articles/screen";
    }

    @GetMapping
    public String articleList(Model model) {
        model.addAttribute("articlesList", articleService.articleList());
        return "articles/list";
    }

    @PostMapping
    public String makeArticle(@ModelAttribute ArticleDto articleDto, @RequestParam MultipartFile image) throws IOException {
        String filePath = "articleImage\\" + image.getOriginalFilename();
        File dest = new File(filePath);
        image.transferTo(dest);

        articleService.insertArticle(articleDto, filePath);
        return "redirect:/articles";
    }
}

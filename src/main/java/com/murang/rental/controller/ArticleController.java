package com.murang.rental.controller;

import com.murang.rental.data.dto.ArticleDto;
import com.murang.rental.data.dto.ArticleRegisterDto;
import com.murang.rental.data.dto.LocationDto;
import com.murang.rental.data.entity.Articles;
import com.murang.rental.service.ArticleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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
@RequiredArgsConstructor//순서때매 그런건데 하나니까 ㄱㅊ
public class ArticleController {

    private final ArticleService articleService;

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

//    @GetMapping("/region")
//    public String articleList(@ModelAttribute LocationDto locationDto, Model model) {
//        model.addAttribute("articleList", articleService.articleList(locationDto));
//        return "articles/list";
//    }


    /**
     * 상품 등록 폼으로 가는 mapping
     *
     * @return 상품 등록 폼
     */
    @GetMapping("/new")
    public String newArticleForm(HttpSession session) {
        session.setAttribute("userId", "123");
        return "articles/form";
    }

    /**
     * 상품 등록 로직
     *
     * @param articleRegisterDto 상품 등록 정보
     * @param image      상품 이미지
     * @return 상품 목록 API
     * @throws IOException
     * @author kimjunyo
     */
    @PostMapping("/new")
    public String registerArticle(@ModelAttribute ArticleRegisterDto articleRegisterDto, @RequestParam MultipartFile image) throws IOException {
        articleService.insertArticle(articleRegisterDto, image);
        return "redirect:/articles";
    }

    /**
     * 상품 아이디로 상품 정보를 가져와 html 폼으로 전달
     *
     * @param articleId 해당 상품 id
     * @param session   로그인 된 유저 체킹
     * @param model     찜 여부, 이미지 파일 포함 상품 정보 담는 용도
     * @return          상세페이지로 이동
     * @author kimjunyo
     */
    @GetMapping("/{articleId}")
    public String detailArticle(@PathVariable Integer articleId, HttpSession session, Model model) {
        Map<String, Object> detailArticle = articleService.detailArticle(articleId);
        boolean heartDto = articleService.heartArticleSearch((String) session.getAttribute("userId"), articleId);
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

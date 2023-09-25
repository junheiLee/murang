package com.murang.rental.controller;

import com.murang.rental.data.dto.article.ArticleDto;
import com.murang.rental.data.dto.article.ArticleRegisterDto;
import com.murang.rental.data.entity.Articles;
import com.murang.rental.data.entity.Category;
import com.murang.rental.service.ArticleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
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

    /**
     * 파라미터로 넘어온 이름으로 해당 category의 목록을 가져온다.
     * 추후 enum에 없는 이름이 파라미터로 넘어온 경우 articles/list로 경로 변경
     *
     * @param query 해당 카테고리 이름
     * @param model articleList
     * @return 상품 목록
     */
    @GetMapping("/search/{query}")
    public String articleSearchList(@PathVariable String query, Model model) {
        Category category = Arrays.stream(Category.values())
                .filter(queryCategory -> queryCategory.name().equals(query))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException());
        model.addAttribute("articlesList", articleService.articleList(category));
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
        if(session.getAttribute("userId") != null) {
            return "articles/form";
        }else{
            return "login";
        }
    }

    /**
     * 상품 등록 로직
     *
     * @param articleRegisterDto 상품 등록 정보
     * @param image              상품 이미지
     * @return 상품 목록 API
     * @throws IOException
     * @author kimjunyo
     */
    @PostMapping("/new")
    public String registerArticle(@ModelAttribute ArticleRegisterDto articleRegisterDto, @RequestParam MultipartFile image, HttpSession session) throws IOException {
        articleService.insertArticle(articleRegisterDto, image, (String) session.getAttribute("userId"));
        return "redirect:/articles";
    }

    /**
     * 상품 아이디로 상품 정보를 가져와 html 폼으로 전달
     *
     * @param articleId 해당 상품 id
     * @param session   로그인 된 유저 체킹
     * @param model     찜 여부, 이미지 파일 포함 상품 정보 담는 용도
     * @return 상세페이지로 이동
     * @author kimjunyo
     */
    @GetMapping("/{articleId}")
    public String detailArticle(@PathVariable Integer articleId, HttpSession session, Model model) {
        Map<String, Object> detailArticle = articleService.detailArticle(articleId);
        boolean heartDto = articleService.heartArticleSearch((String) session.getAttribute("userId"), articleId);
        ArticleDto articleDto = (ArticleDto) detailArticle.get("articleDto");
        LocalDateTime publishDay = articleDto.getPublishDay();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String formattedDate = publishDay.format(formatter);
        model.addAttribute("formattedDate", formattedDate);
        model.addAttribute("heartDto", heartDto);
        model.addAttribute("articleDto", articleDto);
        model.addAttribute("filePath", (String) detailArticle.get("filePath"));
        return "articles/detail";
    }

    @GetMapping("/like/{articleId}")
    public String likeArticle(HttpSession session, @PathVariable Integer articleId) {
        articleService.heartArticle((String) session.getAttribute("userId"), articleId, session);
        return "redirect:/articles/" + articleId.toString();
    }

    @GetMapping("/cancelLike/{articleId}")
    public String cancelHeart(HttpSession session, @PathVariable Integer articleId) {
        articleService.heartArticleDelete((String) session.getAttribute("userId"), articleId, session);
        return "redirect:/articles/" + articleId.toString();
    }

    @GetMapping("/rentals/{articleId}")
    public String rentalArticle(HttpSession session, @PathVariable Integer articleId) {
        articleService.rentalArticle((String) session.getAttribute("userId"), articleId);
        return "redirect:/articles";
    }

    @GetMapping("/rentals")
    public String rentalArticleList(HttpSession session, Model model) {
        List<Articles> rentalArticleList = articleService.rentalArticleList((String) session.getAttribute("userId"));
        model.addAttribute("rentalArticleList", rentalArticleList);
        return "/articles/rentals";
    }

    /**
     * session에서 가져온 User의 pk값으로 등록한 상품리스트를 가져온다.
     *
     * @param session   현재 로그인 돼있는 사용자의 id
     * @return          해당 사용자가 작성한 상품 글 목록
     */


}

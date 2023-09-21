package com.murang.rental.service;

import com.murang.rental.data.dto.ArticleDto;
import com.murang.rental.data.entity.Articles;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface ArticleService {
    ArticleDto insertArticle(ArticleDto articleDto, String filePath) throws IOException;

    List<Articles> articleList();
}

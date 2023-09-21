package com.murang.rental.service.impl;

import com.murang.rental.data.dto.ArticleDto;
import com.murang.rental.data.entity.Articles;
import com.murang.rental.data.repository.ArticlesRepository;
import com.murang.rental.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {

    private final String uploadDir = "static\\\\articles\\\\";

    ArticlesRepository articlesRepository;

    @Autowired
    public ArticleServiceImpl(ArticlesRepository articlesRepository) {
        this.articlesRepository = articlesRepository;
    }

    @Override
    public ArticleDto insertArticle(ArticleDto articleDto, String filePath) throws IOException {
        Articles article = new Articles(articleDto);
        article.setFilePath(filePath);
        Articles savedArticle = articlesRepository.save(article);
        return Articles.articleFactory(savedArticle);
    }

    @Override
    public List<Articles> articleList() {
        return articlesRepository.findAll();
    }
}

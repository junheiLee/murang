package com.murang.rental.service;

import com.murang.rental.data.dto.ArticleDto;
import com.murang.rental.data.entity.Articles;
import com.murang.rental.data.repository.ArticlesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.EntityManager;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class ArticleService {

    ArticlesRepository articlesRepository;

    EntityManager em;

    @Autowired
    public ArticleService(ArticlesRepository articlesRepository, EntityManager em) {
        this.articlesRepository = articlesRepository;
        this.em = em;
    }

    public ArticleDto insertArticle(ArticleDto articleDto, MultipartFile image) throws IOException {
        Articles article = new Articles(articleDto);
        article.setPublishDay(LocalDateTime.now());
        String filePathAndUpload = getFilePathAndUpload(image);
        article.setFilePath(filePathAndUpload);

        Articles savedArticle = articlesRepository.save(article);
        return Articles.articleFactory(savedArticle);
    }

    @Transactional(readOnly = true)
    public List<Articles> articleList() {
        return articlesRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Map<String, Object> detailArticle(Integer id) {
        Articles article = articlesRepository.findById(id).get();
        String filePath = article.getFilePath();
        Map<String, Object> articleInfo = new HashMap();
        articleInfo.put("articleDto", Articles.articleFactory(article));
        articleInfo.put("filePath", filePath);
        return articleInfo;
    }

    public void likeArticle(Integer id) {
        //TODO 2023-09-21 user 엔티티의 likeArticleList에 넣기
    }

    /**
     * file upload 후 file path 가져오는 메서드
     *
     * @param image
     * @return
     * @throws IOException
     */
    private String getFilePathAndUpload(MultipartFile image) throws IOException {
        String filePath = "articleImage\\" + image.getOriginalFilename();
        File dest = new File(filePath);
        image.transferTo(dest);
        return filePath;
    }
}

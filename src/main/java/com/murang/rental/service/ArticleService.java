package com.murang.rental.service;

import com.murang.rental.data.dto.article.ArticleRegisterDto;
import com.murang.rental.data.entity.Articles;
import com.murang.rental.data.entity.Category;
import com.murang.rental.data.entity.HeartArticle;
import com.murang.rental.data.entity.User;
import com.murang.rental.data.repository.HeartRepository;
import com.murang.rental.data.repository.LocationRepository;
import com.murang.rental.data.repository.UserRepository;
import com.murang.rental.data.repository.article.ArticlesRepository;
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
import java.util.Optional;

@Service
public class ArticleService {

    private final ArticlesRepository articlesRepository;
    private final LocationRepository locationRepository;
    private final EntityManager em;
    private final HeartRepository heartRepository;
    private final UserRepository userRepository;

    @Autowired
    public ArticleService(ArticlesRepository articlesRepository,
                          LocationRepository locationRepository,
                          EntityManager em,
                          HeartRepository heartRepository,
                          UserRepository userRepository) {
        this.articlesRepository = articlesRepository;
        this.locationRepository = locationRepository;
        this.em = em;
        this.heartRepository = heartRepository;
        this.userRepository = userRepository;
    }

    @Transactional(readOnly = true)
    public List<Articles> articleList() {
        return articlesRepository.findAll();
    }

    @Transactional(readOnly = true)
    public List<Articles> articleList(Category category)
    {
        return articlesRepository.findAllByCategory(category);
    }

    @Transactional(readOnly = true)
    public List<Articles> myArticleList(String userId) {
//        User user = new User();
//        user.setUserNum(userNum);
        return articlesRepository.findByUserId(userId);
    }
//        @Transactional(readOnly = true)
//    public List<Articles> articleList(LocationDto locationDto) {
//        return articlesRepository.findAllByLocation(locationDto.getSido());
//    }

    @Transactional
    public void insertArticle(ArticleRegisterDto articleRegisterDto, MultipartFile image, String userId) throws IOException {
        User user = userRepository.findByUserId(userId).get();
        Articles article = new Articles(articleRegisterDto);
        article.setPublishDay(LocalDateTime.now());

        String filePathAndUpload = getFilePathAndUpload(image);
        article.setFilePath(filePathAndUpload);
        article.setUser(user);

        Articles savedArticle = articlesRepository.save(article);
        Articles.articleFactory(savedArticle);
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

    @Transactional(readOnly = true)
    public boolean heartArticleSearch(String userId, Integer articleId) {
        Optional<HeartArticle> heartArticle = heartRepository.findByUserIdAndArticleId(userId, articleId);
        return heartArticle.isPresent();
    }

    @Transactional
    public void heartArticle(String userId, Integer articleId) {
        HeartArticle build = new HeartArticle(userId, articleId);
        heartRepository.save(build);
    }

    @Transactional
    public void heartArticleDelete(String userId, Integer articleId) {
        heartRepository.deleteByUserIdAndArticleId(userId, articleId);
    }

    @Transactional
    public void rentalArticle(String userId, Integer articleId) {
        User user = userRepository.findByUserId(userId).get();
        Articles articles = articlesRepository.findById(articleId).get();
        if (!articles.isStatus()) {
            List<Articles> rentArticlesList = user.getRentArticlesList();
            rentArticlesList.add(articles);
            user.setRentArticlesList(rentArticlesList);
            articles.setStatus(true);
            em.persist(user);
            em.persist(articles);
        }
    }

    @Transactional(readOnly = true)
    public List<Articles> rentalArticleList(String userId) {
        return userRepository.findByUserId(userId).get().getRentArticlesList();
    }

    private String getFilePathAndUpload(MultipartFile image) throws IOException {
        String filePath = "articleImage\\" + image.getOriginalFilename();
        File dest = new File(filePath);
        image.transferTo(dest);
        return filePath;
    }
}

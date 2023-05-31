package com.example.springboot;

import com.example.springboot.domain.Article;
import com.example.springboot.mapper.ArticleMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class selectArticle {
    @Autowired
    private ArticleMapper articleMapper;

    @Test
    public void selectArticle() {
        Article article = articleMapper.selectArticle(1);
        System.out.println(article);
        Article article1 = new Article();
        article1.setId(1);
        article1.setContent("入门！");
        articleMapper.updateArticle(article1);
        Article articles = articleMapper.selectArticle(1);
        System.out.println(articles);
    }
}
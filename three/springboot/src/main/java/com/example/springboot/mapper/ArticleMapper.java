package com.example.springboot.mapper;

import com.example.springboot.domain.Article;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ArticleMapper {
    public Article selectArticle(Integer id);
    public int updateArticle(Article article);
}

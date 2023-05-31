package com.example.chapter06_1.service;

import com.example.chapter06_1.domain.Comment;
import com.example.chapter06_1.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CommentService {
    @Autowired
    private CommentRepository commentRepository;
    @Cacheable(cacheNames = "comment",unless = "#result==null")
    public Comment findById(Integer id) {
        Optional<Comment> comment = commentRepository.findById(id);
        if (comment.isPresent()) {
            return comment.get();
        }
        return null;
    }
    @CachePut(cacheNames = "comment",key = "#result.id")
    public Comment updateComment(Comment comment) {
        commentRepository.updateComment(comment.getAuthor(), comment.getaId());
        return comment;
    }
    @CacheEvict(cacheNames = "comment")
    public void deleteComment(Integer id) {
        commentRepository.deleteById(id);
    }
}
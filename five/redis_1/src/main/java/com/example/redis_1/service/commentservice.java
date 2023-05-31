package com.example.redis_1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.stereotype.Service;
import org.example.
@Service
public class commentservice {
    @Autowired
    private CommentRepository commentRepository;
    @Cacheable(cacheNames = "comment", unless = "#result==null")
    public Comment findById(int comment_id){
        Optional<Comment> optional=commentRepository.findById(comment_id);
        if(optional.isPresent()){
            return optional.get();
        }return null;
    }

    @CachePut(cacheNames = "comment", key = "#result.id")
    public Comment updateComment(Comment comment) {
        commentRepository.updateComment(comment.getAuthor(), comment.getaId());
        return comment;
    }

    @CacheEvict(cacheNames = "comment")
    public void deleteComment(int comment_id) {
        commentRepository.deleteById(comment_id);
    }
}
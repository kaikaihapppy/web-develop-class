package com.example.chapter06.service;

import com.example.chapter06.domain.Comment;
import com.example.chapter06.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CommentService {
    @Autowired
    private CommentRepository commentRepository;

    public Comment findById(Integer id) {
        Optional<Comment> comment = commentRepository.findById(id);
        if (comment.isPresent()) {
        }
        return comment.get();
    }

    public Comment updateComment(Comment comment) {
        commentRepository.updataComment(comment.getAuthor(), comment.getaId());
        return comment;
    }

    public void deleteComment(Integer id) {
        commentRepository.deleteById(id);
    }
}
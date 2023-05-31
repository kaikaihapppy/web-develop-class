package com.example.chapter06.controller;

import com.example.chapter06.domain.Comment;
import com.example.chapter06.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommentController {
    @Autowired
    private CommentService commentService;

    @GetMapping("/get/{id}")
    public Comment findById(@PathVariable("id") Integer id) {
        Comment comment = commentService.findById(id);
        return comment;
    }

    @GetMapping("/update/{id}/{author}")
    public Comment updateComment(@PathVariable("id") Integer id, @PathVariable("author") String author) {
        Comment comment = commentService.findById(id);
        comment.setAuthor(author);
        commentService.updateComment(comment);
        return comment;
    }

    @GetMapping("/delete/{id}")
    public void deleteComment(@PathVariable("id") Integer id) {
        commentService.deleteComment(id);
    }
}
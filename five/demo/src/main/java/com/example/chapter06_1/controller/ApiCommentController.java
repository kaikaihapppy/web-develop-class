package com.example.chapter06_1.controller;
import com.example.chapter06_1.domain.Comment;
import com.example.chapter06_1.service.ApiCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/api") // 请求路径
public class ApiCommentController {
    @Autowired
    private ApiCommentService apiCommentService;

    @GetMapping("/get/{id}")
    public Comment findById(@PathVariable("id") Integer id) {
        Comment comment = apiCommentService.findById(id);
        return comment;
    }

    @GetMapping("/update/{id}/{author}")
    public Comment updateComment(@PathVariable("id") Integer id, @PathVariable("author") String author) {
        Comment comment = apiCommentService.findById(id);
        comment.setAuthor(author);
        apiCommentService.updateComment(comment);
        return comment;
    }

    @GetMapping("/delete/{id}")
    public void deleteComment(@PathVariable("id") Integer id) {
        apiCommentService.deleteComment(id);
    }
}
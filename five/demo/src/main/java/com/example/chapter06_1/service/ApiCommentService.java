package com.example.chapter06_1.service;

import com.example.chapter06_1.domain.Comment;
import com.example.chapter06_1.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/api") // 请求路径
public class ApiCommentService {
    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private RedisTemplate redisTemplate;

    public Comment findById(Integer id) { // 先从Redis缓存中查询数据
        Object o = redisTemplate.opsForValue().get("comment_" + id);
        if (o != null) {
            return (Comment) o;
        }// 缓存中没有，就进入数据库查询
        Optional<Comment> byId = commentRepository.findById(id);
        if (byId.isPresent()) {
            Comment comment = byId.get(); // 将查询结果进行缓存，并设置有效期为1天
            redisTemplate.opsForValue().set("comment_" + id, comment, 1, TimeUnit.DAYS);
            return comment;
        }
        return null;
    }

    public Comment updateComment(Comment comment) {
        commentRepository.updateComment(comment.getAuthor(), comment.getId()); // 更新数据后进行缓存更新
        redisTemplate.opsForValue().set("comment_" + comment.getId(), comment);
        return comment;
    }

    public void deleteComment(Integer id) {
        commentRepository.deleteById(id); // 删除数据后进行缓存删除
        redisTemplate.delete("comment_" + id);
    }

}
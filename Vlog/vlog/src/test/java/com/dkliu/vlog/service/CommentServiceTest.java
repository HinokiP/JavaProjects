package com.dkliu.vlog.service;

import com.dkliu.vlog.VlogApiApplication;
import com.dkliu.vlog.model.entity.Comment;
import com.dkliu.vlog.model.vo.CommentVo;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = VlogApiApplication.class)
@Slf4j
class CommentServiceTest {
    @Resource
    private CommentService commentService;

    @Test
    void selectByArticleId() {
        List<CommentVo> commentVos = commentService.selectByArticleId("8198f77b2efe45f6a50b9bfdc3c4c8ed");
        commentVos.forEach(System.out::println);
    }

    @Test
    void addComment() {
        Comment comment = Comment.builder()
                .articleId("8198f77b2efe45f6a50b9bfdc3c4c8ed")
                .userId(1)
                .content("陶然然的评论")
                .createTime(LocalDateTime.now())
                .build();
        List<CommentVo> commentVos = commentService.addComment(comment);
        commentVos.forEach(System.out::println);
    }
}
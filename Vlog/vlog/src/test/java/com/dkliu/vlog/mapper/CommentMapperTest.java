package com.dkliu.vlog.mapper;

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
class CommentMapperTest {
    @Resource
    private CommentMapper commentMapper;

    @Test
    void selectByArticleId() {
        List<CommentVo> commentVos = commentMapper.selectByArticleId("8198f77b2efe45f6a50b9bfdc3c4c8ed");
        commentVos.forEach(System.out::println);
    }

    @Test
    void addComment() {
        Comment comment = Comment.builder()
                .articleId("8198f77b2efe45f6a50b9bfdc3c4c8ed")
                .userId(1)
                .content("测试评论")
                .createTime(LocalDateTime.now())
                .build();
        commentMapper.addComment(comment);
    }
}
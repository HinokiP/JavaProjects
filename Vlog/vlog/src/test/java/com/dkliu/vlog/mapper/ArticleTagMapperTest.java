package com.dkliu.vlog.mapper;

import com.dkliu.vlog.VlogApiApplication;
import com.dkliu.vlog.model.entity.ArticleTag;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = VlogApiApplication.class)
@Slf4j
class ArticleTagMapperTest {
    @Resource
    private ArticleTagMapper articleTagMapper;

    @Test
    void insertArticleTags() {
        List<ArticleTag> articleTagList = new ArrayList<>();
        articleTagList.add(ArticleTag.builder().articleId("1").tagName("leecode").build());
        articleTagList.add(ArticleTag.builder().articleId("2").tagName("NLP").build());
        articleTagMapper.insertArticleTags(articleTagList);

    }

    @Test
    void selectByArticleId() {
    }
}
package com.dkliu.vlog.service;

import com.dkliu.vlog.VlogApiApplication;
import com.dkliu.vlog.model.entity.Article;
import com.dkliu.vlog.model.vo.ArticleVo;
import com.dkliu.vlog.task.ArticleTask;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import java.util.List;
import java.util.concurrent.*;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest(classes = VlogApiApplication.class)
@Slf4j
class ArticleServiceTest {
    @Resource
    private ArticleService articleService;
    @Resource
    private ArticleTask articleTask;

    @Test
    void insertArticles() {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(4, 8, 5,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy());
        Future<List<Article>> future = executor.submit(articleTask);
        List<Article> articles = null;
        try {
            articles = future.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        articleService.insertArticles(articles);
    }

    @Test
    void selectByPage() {
        //PageInfo<ArticleVo> articlePageInfo = articleService.selectByPage(1, 9, 1);
        PageInfo<ArticleVo> articlePageInfo = articleService.selectByPage(1, 9);
        System.out.println(articlePageInfo.getList().size());
    }

    @Test
    void getRecommendArticles() {
        List<ArticleVo> recommendArticles = articleService.getRecommendArticles();
        recommendArticles.forEach(System.out::println);
    }

    @Test
    void getDetail() {
        ArticleVo detail = articleService.getDetail("01f0e388e74e48258a7afb55faaa5c3e");
        System.out.println(detail);
    }
}
package com.dkliu.vlog.service;

import com.dkliu.vlog.VlogApiApplication;
import com.dkliu.vlog.model.entity.Article;
import com.dkliu.vlog.task.ArticleTask;
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
        } catch (InterruptedException | ExecutionException e){
            e.printStackTrace();
        }
        articleService.insertArticles(articles);
    }

        @Test
        void selectAll () {
            List<Article> articles = articleService.selectAll();
            System.out.println(articles);
        }
    }
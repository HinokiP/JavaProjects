package com.dkliu.vlog.mapper;

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
class ArticleMapperTest {
    @Resource
    private ArticleMapper articleMapper;
    @Resource
    private ArticleTask articleTask;

    @Test
    void insertArticles() throws ExecutionException, InterruptedException {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(4, 8, 5,
                TimeUnit.SECONDS, new SynchronousQueue<>());
        Future<List<Article>> future = executor.submit(articleTask);
        List<Article> articles = future.get();
        int count = articleMapper.insertArticles(articles);
        System.out.println(count);
    }

    @Test
    void selectAll() {
        List<Article> articles = articleMapper.selectAll();
        System.out.println(articles);
    }
}
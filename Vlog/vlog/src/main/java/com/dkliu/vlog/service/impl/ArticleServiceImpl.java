package com.dkliu.vlog.service.impl;

import com.dkliu.vlog.mapper.ArticleMapper;
import com.dkliu.vlog.mapper.ArticleTagMapper;
import com.dkliu.vlog.model.entity.Article;
import com.dkliu.vlog.model.entity.ArticleTag;
import com.dkliu.vlog.service.ArticleService;
import com.dkliu.vlog.task.ArticleTask;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName ArticleServiceImpl
 * @Description TODO
 * @Author Hinoki
 * @Date 2020/12/15
 **/

@Service
@Slf4j
public class ArticleServiceImpl implements ArticleService {
    @Resource
    private ArticleMapper articleMapper;
    @Resource
    private ArticleTagMapper articleTagMapper;

    @Override
    public void insertArticles(List<Article> articles) {
        articleMapper.insertArticles(articles);
        assert articles != null;
        articles.forEach(article -> {
            if (article.getTagList() != null) {
                articleTagMapper.insertArticleTags(article.getTagList());
            }
        });
    }

    @Override
    public List<Article> selectAll() {
        List<Article> articles = articleMapper.selectAll();
        articles.forEach(article -> {
            List<ArticleTag> articleTags = articleTagMapper.selectByArticleId(article.getId());
            article.setTagList(articleTags);
        });
        return articles;
    }
}

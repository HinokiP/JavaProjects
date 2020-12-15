package com.dkliu.vlog.service;

import com.dkliu.vlog.model.entity.Article;

import java.util.List;

/**
 * @ClassName ArticleService
 * @Description TODO
 * @Author Hinoki
 * @Date 2020/12/15
 **/

public interface ArticleService {
    /**
     * 批量新增文章
     *
     * @param articles 文章集合
     */
    void insertArticles(List<Article> articles);

    /**
     * 查询所有文章
     *
     * @return List<Article>
     */
    List<Article> selectAll();
}

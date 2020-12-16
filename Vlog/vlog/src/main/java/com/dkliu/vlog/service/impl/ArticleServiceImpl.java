package com.dkliu.vlog.service.impl;

import com.dkliu.vlog.mapper.ArticleMapper;
import com.dkliu.vlog.mapper.ArticleTagMapper;
import com.dkliu.vlog.model.entity.Article;
import com.dkliu.vlog.model.entity.ArticleTag;
import com.dkliu.vlog.service.ArticleService;
import com.dkliu.vlog.task.ArticleTask;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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
    public PageInfo<Article> selectByPage(int pageNum, int pageSize, int userId) {
        //将参数传给这个方法就可以实现物理分页
        PageHelper.startPage(pageNum, pageSize);
        //先根据用户id查到所有数据
        Page<Article> articlePage = articleMapper.selectAll(userId);
        //将这些数据作为入参构建出PageInfo(包含了总页数，当前页码、每页数量、当前页数据list等等一堆属性和方法)
        return new PageInfo<>(articlePage);
    }
}
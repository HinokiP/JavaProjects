package com.dkliu.vlog.mapper;

import com.dkliu.vlog.model.entity.Article;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName ArticleTagMapper
 * @Description TODO
 * @Author Hinoki
 * @Date 2020/12/15
 **/

public interface ArticleMapper {
    /**
     * 批量插入文章
     *
     * @param articleList 文章集合
     * @return int
     */
    @Insert({
            "<script>",
            "INSERT INTO t_article (id,category,user_id,title,cover,summary,content,url,publish_date) VALUES ",
            "<foreach collection='articleList' item='item' index='index' separator=','>",
            "(#{item.id}, #{item.category}, #{item.userId}, #{item.title}, #{item.cover}, #{item.summary}, #{item.content}," +
            "#{item.url}, #{item.publishDate})",
            "</foreach>",
            "</script>"
    })
    int insertArticles(@Param(value = "articleList") List<Article> articleList);

    /**
     * 查询用户的所有文章，一对多关联查询，“一方”（文章）需要存放“多方”（文章标签）的集合，双向一对多就是多对多了
     * 最后一行SQL很重要！其中property时Article中的定义的“多方”集合变量
     * column是文章表中的文章id，也就是一对多查询的依据
     * many为在”多方“mapper中的查询方法（务必对应）
     *
     * @param userId 用户ID
     * @return 文章集合
     */
    @Select("SELECT * FROM t_article a WHERE a.user_id = #{userId} ")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "category", column = "category"),
            @Result(property = "userId", column = "user_id"),
            @Result(property = "title", column = "title"),
            @Result(property = "cover", column = "cover"),
            @Result(property = "summary", column = "summary"),
            @Result(property = "content", column = "content"),
            @Result(property = "url", column = "url"),
            @Result(property = "publishDate", column = "publish_date"),
            @Result(property = "tagList", column = "id",
                    many = @Many(select = "com.dkliu.vlog.mapper.ArticleTagMapper.selectByArticleId"))
    })
    Page<Article> selectAll(@Param(value = "userId") int userId);
}

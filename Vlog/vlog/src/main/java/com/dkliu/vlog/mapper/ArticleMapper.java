package com.dkliu.vlog.mapper;

import com.dkliu.vlog.model.entity.Article;
import com.dkliu.vlog.model.vo.ArticleVo;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @ClassName ArticleTagMapper
 * @Description TODO
 * @Author Hinoki
 * @Date 2020/12/15
 **/

public interface ArticleMapper {

    /**
     * 新增文章
     *
     * @param article 入参
     */
    @Insert("INSERT INTO t_article (id,category,user_id,title,cover,summary,content,create_time,total_words,duration,page_view) " +
    "VALUES (#{article.id}, #{article.category}, #{article.userId}, #{article.title}, #{article.cover}, #{article.summary}, #{article.content}, #{article.createTime}, #{article.totalWords}, #{article.duration}, #{article.pageView})")
    void add(@Param("article") Article article);

    /**
     * 批量插入文章
     *
     * @param articleList 文章集合
     * @return int
     */
    @Insert({
            "<script>",
            "INSERT INTO t_article (id,category,user_id,title,cover,summary,content,url,create_time,total_words,duration,page_view) VALUES ",
            "<foreach collection='articleList' item='item' index='index' separator=','>",
            "(#{item.id}, #{item.category}, #{item.userId}, #{item.title}, #{item.cover}, #{item.summary}, #{item.content}," +
                    "#{item.url}, #{item.createTime}, #{item.totalWords}, #{item.duration}, #{item.pageView})",
            "</foreach>",
            "</script>"
    })
    int insertArticles(@Param(value = "articleList") List<Article> articleList);

    /**
     * 查询某个用户的6篇推荐文章
     *
     * @return List<Article>
     */
    @Select("SELECT a.id,a.category,a.user_id,a.title,a.cover,a.summary,b.nickname,b.avatar " +
            "FROM t_article a " +
            "LEFT JOIN t_user b " +
            "ON a.user_id = b.id " +
            "ORDER BY a.page_view DESC " +
            "LIMIT 6 ")
    List<ArticleVo> getRecommendArticles();

    /**
     * 查询用户的所有文章，一对多关联查询，“一方”（文章）需要存放“多方”（文章标签）的集合，双向一对多就是多对多了
     * 最后一行SQL很重要！其中property时Article中的定义的“多方”集合变量
     * column是文章表中的文章id，也就是一对多查询的依据
     * many为在”多方“mapper中的查询方法（务必对应）
     *
     * @return 文章集合
     */
    @Select("SELECT a.id,a.category,a.user_id,a.title,a.cover,a.summary,a.create_time,b.nickname,b.avatar " +
            "FROM t_article a " +
            "LEFT JOIN t_user b ON a.user_id = b.id " +
            "ORDER BY a.create_time DESC")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "category", column = "category"),
            @Result(property = "userId", column = "user_id"),
            @Result(property = "title", column = "title"),
            @Result(property = "cover", column = "cover"),
            @Result(property = "summary", column = "summary"),
            @Result(property = "createTime", column = "create_time"),
            @Result(property = "tagList", column = "id",
                    many = @Many(select = "com.dkliu.vlog.mapper.ArticleTagMapper.selectByArticleId")),
            @Result(property = "nickname", column = "nickname"),
            @Result(property = "avatar", column = "avatar")
    })
    Page<ArticleVo> selectAll();

    /**
     * 根据文章id查找文章详情
     *
     * @param id 文章id
     * @return Article
     */
    @Select("SELECT a.*,b.nickname,b.avatar FROM t_article a LEFT JOIN t_user b ON a.user_id = b.id WHERE a.id = #{id}")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "category", column = "category"),
            @Result(property = "userId", column = "user_id"),
            @Result(property = "title", column = "title"),
            @Result(property = "cover", column = "cover"),
            @Result(property = "content", column = "content"),
            @Result(property = "createTime", column = "create_time"),
            @Result(property = "totalWords", column = "total_words"),
            @Result(property = "duration", column = "duration"),
            @Result(property = "pageView", column = "page_view"),
            @Result(property = "tagList", column = "id",
                    many = @Many(select = "com.dkliu.vlog.mapper.ArticleTagMapper.selectByArticleId")),
            @Result(property = "commentList", column = "id",
                    many = @Many(select = "com.dkliu.vlog.mapper.CommentMapper.selectByArticleId")),
            @Result(property = "nickname", column = "nickname"),
            @Result(property = "avatar", column = "avatar")
    })
    ArticleVo getDetail(@Param(value = "id") String id);
}

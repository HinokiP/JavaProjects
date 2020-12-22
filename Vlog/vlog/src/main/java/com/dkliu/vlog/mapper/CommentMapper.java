package com.dkliu.vlog.mapper;

import com.dkliu.vlog.model.entity.Comment;
import com.dkliu.vlog.model.vo.CommentVo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @ClassName CommentMapper
 * @Description TODO
 * @Author Hinoki
 * @Date 2020/12/22
 **/

public interface CommentMapper {
    /**
     * 根据文章id查询评论
     *
     * @param articleId 文章id
     * @return 文章所有评论
     */
    @Select("SELECT a.*,b.nickname,b.avatar " +
            "FROM t_comment a " +
            "LEFT JOIN t_user b " +
            "ON a.user_id = b.id " +
            "WHERE a.article_id = #{articleId} " +
            "ORDER BY a.id DESC ")
    List<CommentVo> selectByArticleId(@Param("articleId") String articleId);

    /**
     * 新增评论
     *
     * @param comment 评论
     */
    @Insert("INSERT INTO t_comment (article_id,user_id,content,create_time) " +
            "VALUES (#{comment.articleId},#{comment.userId},#{comment.content},#{comment.createTime} )")
    void addComment(@Param("comment") Comment comment);
}

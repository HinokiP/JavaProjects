package com.dkliu.vlog.service;

import com.dkliu.vlog.mapper.CommentMapper;
import com.dkliu.vlog.model.entity.Comment;
import com.dkliu.vlog.model.vo.CommentVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName CommentService
 * @Description TODO
 * @Author Hinoki
 * @Date 2020/12/22
 **/

public interface CommentService {
    /**
     * 根据文章id查询评论
     *
     * @param articleId
     * @return
     */
    List<CommentVo> selectByArticleId(String articleId);

    /**
     * 新增评论
     *
     * @param comment 新增品论对象
     * @return 所有评论视图列表
     */
    List<CommentVo> addComment(@Param("comment") Comment comment);
}

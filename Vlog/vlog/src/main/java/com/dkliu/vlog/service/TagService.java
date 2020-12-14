package com.dkliu.vlog.service;

import com.dkliu.vlog.model.entity.Tag;

import java.util.List;

/**
 * @ClassName TagService
 * @Description TODO
 * @Author Hinoki
 * @Date 2020/12/14
 **/

public interface TagService {
    /**
     * 查询所有标签
     *
     * @return 所有标签
     */
    List<Tag> selectAll();
}

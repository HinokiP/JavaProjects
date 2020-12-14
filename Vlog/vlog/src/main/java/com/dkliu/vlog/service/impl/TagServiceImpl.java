package com.dkliu.vlog.service.impl;

import com.dkliu.vlog.mapper.TagMapper;
import com.dkliu.vlog.model.entity.Tag;
import com.dkliu.vlog.service.TagService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName TagServiceImpl
 * @Description TODO
 * @Author Hinoki
 * @Date 2020/12/14
 **/

@Service
public class TagServiceImpl implements TagService {
    @Resource
    private TagMapper tagMapper;

    @Override
    public List<Tag> selectAll() {
        return tagMapper.selectAll();
    }
}

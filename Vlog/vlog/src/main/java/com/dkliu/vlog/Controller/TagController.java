package com.dkliu.vlog.Controller;

import com.dkliu.vlog.common.ResponseResult;
import com.dkliu.vlog.service.TagService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @ClassName TagContorller
 * @Description TODO
 * @Author Hinoki
 * @Date 2020/12/14
 **/

@RestController
@RequestMapping(value = "/api/tag")
@Slf4j
public class TagController {
    @Resource
    private TagService tagService;

    @GetMapping("all")
    public ResponseResult getTags() {
        return ResponseResult.success(tagService.selectAll());
    }
}

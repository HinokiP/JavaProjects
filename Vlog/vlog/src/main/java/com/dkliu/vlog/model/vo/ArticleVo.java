package com.dkliu.vlog.model.vo;

import com.dkliu.vlog.model.entity.Article;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @ClassName ArticleVo
 * @Description TODO
 * @Author Hinoki
 * @Date 2020/12/21
 **/

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class ArticleVo {
    private String id;
    private String category;
    private Integer userId;
    private String title;
    private String cover;
    private String summary;
    private String content;
    private String url;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private LocalDateTime createTime;
    private String totalWords;
    private Integer duration;
    private Integer pageView;
    private List<Article> tagList;
    private String nickname;
    private String avatar;
}

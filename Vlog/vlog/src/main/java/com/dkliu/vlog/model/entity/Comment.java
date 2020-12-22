package com.dkliu.vlog.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @ClassName Comment
 * @Description TODO
 * @Author Hinoki
 * @Date 2020/12/22
 **/

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Comment {
    private Integer id;
    private String articleId;
    private Integer userId;
    private String content;
    private LocalDateTime createTime;
}

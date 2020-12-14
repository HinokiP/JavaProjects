package com.dkliu.vlog.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName Tag
 * @Description TODO
 * @Author Hinoki
 * @Date 2020/12/13
 **/

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Tag {
    private Integer id;
    private String tagName;
    private String tagColor;
}

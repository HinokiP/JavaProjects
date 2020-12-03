package com.dkliu.vlog.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName Card
 * @Description TODO
 * @Author Hinoki
 * @Date 2020/12/3
 **/

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Card {
    private Integer id;
    private String title;
    private String bgImg;
    private String content;
}

package com.dkliu.vlog.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName WxLoginDto
 * @Description TODO
 * @Author Hinoki
 * @Date 2020/12/8
 **/

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class WxLoginDto {
    private String wxOpenId;
    private String nickname;
    private Integer gender;
    private String avatar;
}

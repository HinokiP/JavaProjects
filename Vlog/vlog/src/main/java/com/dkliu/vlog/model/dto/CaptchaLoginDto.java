package com.dkliu.vlog.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName CaptchaLoginDto
 * @Description TODO
 * @Author Hinoki
 * @Date 2020/12/11
 **/

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class CaptchaLoginDto {
    private String phone;
    private String password;
    private String captcha;
}

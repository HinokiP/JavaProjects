package com.dkliu.vlog.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName PhoneLoginDto
 * @Description TODO
 * @Author Hinoki
 * @Date 2020/12/6
 **/

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class PhoneLoginDto {
    private String phone;
    private String code;
}

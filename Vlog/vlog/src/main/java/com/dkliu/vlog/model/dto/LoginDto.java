package com.dkliu.vlog.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName LoginDto
 * @Description TODO
 * @Author Hinoki
 * @Date 2020/12/5
 **/

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class LoginDto {
    private String phone;
    private String password;
}

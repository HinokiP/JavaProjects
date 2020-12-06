package com.dkliu.vlog.service;

import com.dkliu.vlog.model.dto.LoginDto;
import com.dkliu.vlog.model.dto.PhoneLoginDto;
import com.dkliu.vlog.model.entity.User;

/**
 * @ClassName UserService
 * @Description TODO
 * @Author Hinoki
 * @Date 2020/12/5
 **/

public interface UserService {
    /**
     * 登录
     *
     * @param loginDto 登录dto对象
     * @return boolean
     */
    boolean login(LoginDto loginDto);

    /**
     * 根据手机号查找用户
     *
     * @param phone 手机号
     * @return User
     */
    User getUser(String phone);

    /**
     * 手机短信验证码登录
     *
     * @param phoneLoginDto 入参
     * @return boolean
     */
    boolean phoneLogin(PhoneLoginDto phoneLoginDto);

    /**
     * 修改用户信息
     *
     * @param user 用户对象
     * @return User
     */
    User updateUser(User user);
}

package com.dkliu.vlog.service;

import com.dkliu.vlog.model.dto.CaptchaLoginDto;
import com.dkliu.vlog.model.dto.LoginDto;
import com.dkliu.vlog.model.dto.PhoneLoginDto;
import com.dkliu.vlog.model.dto.WxLoginDto;
import com.dkliu.vlog.model.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.multipart.MultipartFile;

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

    /**
     * 上传到OSS
     *
     * @param file 文件对象
     * @return 上传后的url
     */
    String uploadFile(MultipartFile file);

    /**
     * 微信登陆
     *
     * @param wxLoginDto 入参
     * @return boolean
     */
    User wxLogin(WxLoginDto wxLoginDto);

    /**
     * 验证码登录
     *
     * @param captchaLoginDto 入参
     * @return User
     */
    User captchaLogin(CaptchaLoginDto captchaLoginDto);

    /**
     * 根据id获取用户信息
     *
     * @param id id
     * @return User
     */
    User getUser(@Param("id") int id);
}

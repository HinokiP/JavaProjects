package com.dkliu.vlog.service.impl;

import com.dkliu.vlog.mapper.UserMapper;
import com.dkliu.vlog.model.dto.LoginDto;
import com.dkliu.vlog.model.entity.User;
import com.dkliu.vlog.service.UserService;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.SQLException;

/**
 * @ClassName UserServiceImpl
 * @Description TODO
 * @Author Hinoki
 * @Date 2020/12/5
 **/

@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;

    @Override
    public boolean login(LoginDto loginDto) {
        User user = getUser(loginDto.getPhone());
        if (user != null) {
            //对客户端传递的密码机型加密后和数据库中的user的密码比较
            return DigestUtils.md5Hex(loginDto.getPassword()).equals(user.getPassword());
        }
        return false;
    }

    @Override
    public User getUser(String phone) {
        User user = null;
        try {
            user = userMapper.findUserByPhone(phone);
        } catch (SQLException throwables) {
            System.err.println("根据手机号查找用户出现异常");
        }
        return user;
    }
}

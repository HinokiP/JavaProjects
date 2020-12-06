package com.dkliu.vlog.mapper;

import com.dkliu.vlog.VlogApiApplication;
import com.dkliu.vlog.common.Gender;
import com.dkliu.vlog.model.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;

@SpringBootTest(classes = VlogApiApplication.class)
@Slf4j
class UserMapperTest {
    //注入UserMapper的实例
    @Resource
    private UserMapper userMapper;

    @Test
    void insert() throws Exception {
        User user = User.builder()
                .phone("13174153000")
                .password("123456")
                .nickname("Hinoki")
                .avatar("1.jpg")
                .gender(Gender.male.type)
                .birthday(LocalDate.now())
                .address("江苏徐州")
                .createTime(LocalDateTime.now())
                .build();
        userMapper.insert(user);
    }

    @Test
    void findUserByPhone() throws SQLException {
        User user = userMapper.findUserByPhone("13174153000");
        log.info(String.valueOf(user));
    }
}
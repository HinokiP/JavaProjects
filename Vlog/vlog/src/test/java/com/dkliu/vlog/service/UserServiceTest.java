package com.dkliu.vlog.service;

import com.dkliu.vlog.VlogApiApplication;
import com.dkliu.vlog.common.Gender;
import com.dkliu.vlog.model.dto.LoginDto;
import com.dkliu.vlog.model.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.digest.DigestUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = VlogApiApplication.class)
@Slf4j
class UserServiceTest {

    @Resource
    private UserService userService;

    @Test
    void login() {
        LoginDto loginDto = LoginDto.builder()
                .phone("13174153000")
                .password("123456")
                .build();
        boolean flag = userService.login(loginDto);
        assertTrue(flag);
    }

    @Test
    void getUser() {
        User user = userService.getUser("13174153000");
        log.info(String.valueOf(user));
    }

    @Test
    void updateUser() {
        User user = User.builder()
                .phone("13174153016")
                .password(DigestUtils.md5Hex("123123"))
                .nickname("dkLiu")
                .avatar("https://pic-go-hinoki.oss-cn-beijing.aliyuncs.com/share-app/tx.jpg")
                .gender(Gender.secret.type)
                .birthday(LocalDate.of(2000, 9, 2))
                .address("江苏徐州")
                .build();
        userService.updateUser(user);
    }
}
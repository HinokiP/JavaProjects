package com.dkliu.vlog.util;

import com.dkliu.vlog.VlogApiApplication;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = VlogApiApplication.class)
@Slf4j
class SmsUtilTest {

    @Resource
    private SmsUtil smsUtil;

    @Test
    void sendSms() {
        smsUtil.sendSms("13174153016","123123");
    }
}
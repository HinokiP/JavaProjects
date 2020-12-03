package com.dkliu.vlog.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName HelloController
 * @Description TODO
 * @Author Hinoki
 * @Date 2020/12/3
 **/

@RestController
@RequestMapping(value = "api")
public class HelloController {

    @GetMapping("hello")
    public String hello() {
        return "hello spring boot";
    }
}

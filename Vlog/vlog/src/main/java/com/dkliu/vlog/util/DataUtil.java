package com.dkliu.vlog.util;

import com.dkliu.vlog.model.Card;

import java.util.Arrays;
import java.util.List;

/**
 * @ClassName DataUtil
 * @Description TODO
 * @Author Hinoki
 * @Date 2020/12/3
 **/

public class DataUtil {
    public static List<Card> initCards() {
        Card[] cards = new Card[]{
                Card.builder()
                        .id(1)
                        .title("Java学习")
                        .bgImg("https://pic-go-hinoki.oss-cn-beijing.aliyuncs.com/img/mario1.png")
                        .content("Java学习")
                        .build(),
                Card.builder()
                        .id(1)
                        .title("Java Script学习")
                        .bgImg("https://pic-go-hinoki.oss-cn-beijing.aliyuncs.com/img/mario2.png")
                        .content("Java Script学习")
                        .build(),
                Card.builder()
                        .id(1)
                        .title("Linux学习")
                        .bgImg("https://pic-go-hinoki.oss-cn-beijing.aliyuncs.com/img/mario3.png")
                        .content("Linux学习")
                        .build(),
                Card.builder()
                        .id(1)
                        .title("MySQL学习")
                        .bgImg("https://pic-go-hinoki.oss-cn-beijing.aliyuncs.com/img/mario4.png")
                        .content("SpringCloud学习")
                        .build(),
                Card.builder()
                        .id(1)
                        .title("Python学习")
                        .bgImg("https://pic-go-hinoki.oss-cn-beijing.aliyuncs.com/img/mario5.png")
                        .content("SpringCloud学习")
                        .build()
        };
        return Arrays.asList(cards);
    }
}

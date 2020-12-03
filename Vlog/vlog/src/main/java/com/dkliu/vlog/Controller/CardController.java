package com.dkliu.vlog.Controller;

import com.dkliu.vlog.common.ResponseResult;
import com.dkliu.vlog.common.ResultCode;
import com.dkliu.vlog.model.Card;
import com.dkliu.vlog.utils.DataUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ClassName CardController
 * @Description TODO
 * @Author Hinoki
 * @Date 2020/12/3
 **/

@RestController
@RequestMapping(value = "api")
public class CardController {

    @GetMapping("cards")
    public ResponseResult getCards() {
        List<Card> cards = DataUtil.initCards();
        ResultCode success = ResultCode.SUCCESS;
        return ResponseResult.builder()
                .code(success.code())
                .msg(success.message())
                .data(cards)
                .build();
    }
}

package com.dkliu.vlog.exception;

import com.dkliu.vlog.common.ResultCode;

/**
 * @ClassName CustomException
 * @Description TODO
 * @Author Hinoki
 * @Date 2020/12/20
 **/

public class CustomException extends RuntimeException{
    protected ResultCode resultCode;

    public CustomException(String msg, ResultCode resultCode) {
        super(msg);
        this.resultCode = resultCode;
    }

    public ResultCode getResultCode() {
        return resultCode;
    }
}

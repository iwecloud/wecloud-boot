package com.we.cloud.core.exception;

import lombok.Data;

/**
 * @ClassName BaseException
 * @description
 * @author wecloud
 */
@Data
public class BaseException extends RuntimeException{

    private String errCode;
    private Object[] args;
    private String errMsg;

    public BaseException(String errMsg) {
        this.errMsg = errMsg;
    }

    public BaseException(String errMsg, Throwable cause) {
        super(cause);
        this.errMsg = errMsg;
    }

    public BaseException(String errMsg, Object[] args) {
        this.args = args;
        this.errMsg = errMsg;
    }

    public BaseException(String errMsg, Object[] args, Throwable cause) {
        super(cause);
        this.args = args;
        this.errMsg = errMsg;
    }
}

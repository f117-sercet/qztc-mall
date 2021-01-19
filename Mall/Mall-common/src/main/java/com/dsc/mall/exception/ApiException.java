package com.dsc.mall.exception;

import com.dsc.mall.api.IErrorCode;
import io.netty.util.concurrent.ImmediateEventExecutor;

/**
 * 自定API异常
 * @author 60221
 */
public class ApiException extends RuntimeException {
    private IErrorCode errorCode;
    public  ApiException(IErrorCode errorCode){
        super(errorCode.getMessage());
        this.errorCode=errorCode;
    }
    public ApiException(String message) {
        super(message);
    }

    public ApiException(Throwable cause) {
        super(cause);
    }

    public ApiException(String message, Throwable cause) {
        super(message, cause);
    }

    public IErrorCode getErrorCode() {
        return errorCode;
    }
}

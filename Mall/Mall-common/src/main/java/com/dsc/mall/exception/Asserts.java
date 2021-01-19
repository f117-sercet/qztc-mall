package com.dsc.mall.exception;

import com.dsc.mall.api.IErrorCode;

/**
 * @author 60221
 * 断言处理，用于抛出各种API异常
 */
public class Asserts {public static void fail(String message) {
    throw new ApiException(message);
}

    public static void fail(IErrorCode errorCode) {
        throw new ApiException(errorCode);
    }

}

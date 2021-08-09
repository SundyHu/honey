package io.ryan.honey.common.core.exception;

/**
 * HoneyException
 *
 * @author hkc
 * @version 1.0.0
 * @date 2021-08-09 15:07
 */
public class HoneyException extends RuntimeException {

    public HoneyException(String msg) {
        super(msg);
    }

    public HoneyException(String msg, Throwable throwable) {
        super(msg, throwable);
    }
}

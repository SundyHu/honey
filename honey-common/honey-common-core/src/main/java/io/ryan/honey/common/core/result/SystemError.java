package io.ryan.honey.common.core.result;

/**
 * 通用系统错误
 *
 * @author Ryan
 * @version 1.0.0
 * @date 2021-08-09 15:09
 */
public enum SystemError implements ErrorMessage {

    /**
     * 操作成功
     */
    SUCCESS(1, "操作成功"),
    /**
     * 操作失败
     */
    FAILURE(0, "操作失败");

    private final int code;

    private final String message;

    SystemError(int code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public int getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}

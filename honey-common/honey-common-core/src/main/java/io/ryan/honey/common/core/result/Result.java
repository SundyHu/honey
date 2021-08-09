package io.ryan.honey.common.core.result;

import lombok.Data;

import java.io.Serializable;

/**
 * 通用接口返回对象
 *
 * @author Ryan
 * @version 1.0.0
 * @date 2021-08-09 15:12
 */
@Data
public class Result<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 响应码(1请求成功,非1请求失败)
     */
    private final int code;

    /**
     * 响应码信息
     */
    private final String message;

    /**
     * 响应数据
     */
    private T data;

    private Result() {
        this.code = SystemError.SUCCESS.getCode();
        this.message = SystemError.SUCCESS.getMessage();
    }

    private Result(T data) {
        this();
        this.data = data;
    }

    private Result(ErrorMessage errorMessage) {
        this.code = errorMessage.getCode();
        this.message = errorMessage.getMessage();
    }

    private Result(ErrorMessage errorMessage, T data) {
        this(errorMessage);
        this.data = data;
    }

    public static <T> Result<T> ok() {
        return new Result<>();
    }

    public static <T> Result<T> ok(T data) {
        return new Result<>(data);
    }

    public static <T> Result<T> fail() {
        return new Result<>(SystemError.FAILURE);
    }

    public static <T> Result<T> fail(ErrorMessage errorMessage) {
        return new Result<>(errorMessage);
    }
}

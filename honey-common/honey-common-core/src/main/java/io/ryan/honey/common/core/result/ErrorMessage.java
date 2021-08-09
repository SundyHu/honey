package io.ryan.honey.common.core.result;

/**
 * 通用错误消息接口，模块类错误消息可通过扩展此接口扩展
 *
 * @author Ryan
 * @version 1.0.0
 * @date 2021-08-09 15:08
 */
public interface ErrorMessage {

    /**
     * 获取响应码
     *
     * @return 响应码
     */
    int getCode();

    /**
     * 获取响应信息
     *
     * @return 响应信息
     */
    String getMessage();
}

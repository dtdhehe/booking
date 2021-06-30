package com.dtdhehe.common.data;

import lombok.Data;


@Data
public class JsonResult<T> {

    /**
     * 数据
     */
    private T data;

    /**
     * 错误吗
     */
    private Integer code;

    /**
     * 错误消息
     */
    private String message;

    /**
     * 调用成功，不响应数据
     * @param <T>
     * @return
     */
    public static <T> JsonResult<T> success() {
        JsonResult<T> result = new JsonResult<>();
        result.setCode(200);
        return result;
    }

    /**
     * 调用成功，返回data
     * @param <T>
     * @return
     */
    public static <T> JsonResult<T> success(T data) {
        JsonResult<T> result = new JsonResult<>();
        result.setCode(200);
        result.setData(data);
        return result;
    }

    /**
     * 返回空的错误消息
     * @param <T>
     * @return
     */
    public static <T> JsonResult<T> error() {
        return error(500,"");
    }

    /**
     * 返回指定消息的错误响应
     * @param errorMessage
     * @param <T>
     * @return
     */
    public static <T> JsonResult<T> error(String errorMessage) {
        return error(500,errorMessage);
    }

    /**
     * 返回指定错误码和消息的错误响应
     * @param errorCode
     * @param errorMessage
     * @param <T>
     * @return
     */
    public static <T> JsonResult<T> error(Integer errorCode, String errorMessage) {
        JsonResult<T> result = new JsonResult<>();
        result.setCode(errorCode);
        result.setMessage(errorMessage);
        return result;
    }

}

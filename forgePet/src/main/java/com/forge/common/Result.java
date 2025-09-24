package com.forge.common;

/**
 * 通用返回结果，封装增删改的响应数据
 */
public record Result(Integer code, String msg, Object data) {

    // 保持原有构造函数兼容性
    public Result(Integer code, String msg) {
        this(code, msg, null);
    }

    public static Result choice(String msg, boolean res) {
        if (res) return new Result(1, msg + "成功");
        else return new Result(0, msg + "失败");
    }

    public static Result error(String msg) {
        return new Result(0, msg);
    }

    public static Result success(String msg) {
        return new Result(1, msg);
    }

    // 添加支持数据的成功响应方法
    public static Result success(Object data) {
        return new Result(1, "操作成功", data);
    }

    public static Result success(String msg, Object data) {
        return new Result(1, msg, data);
    }
}

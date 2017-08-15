package me.jinkun.rds.common.dto;

import java.io.Serializable;

/**
 * Created by zongguang on 2017/5/18 0018.
 */
public class Result<T> implements Serializable {

    private static final long serialVersionUID = -7284167079213189980L;
    private int code;
    private String msg;
    private T t;

    public Result() {
    }

    public Result(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Result(int code, String msg, T t) {
        this.code = code;
        this.msg = msg;
        this.t = t;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getT() {
        return t;
    }

    public Result setT(T t) {
        this.t = t;
        return this;
    }

    public static Result ok(String msg) {
        return new Result(CODE_OK, msg, null);
    }

    public static Result ok() {
        return ok(CODE_OK_MSG);
    }

    public static Result fail(String msg) {
        return new Result(CODE_FAIL, msg, null);
    }

    public static Result fail() {
        return fail(CODE_FAIL_MSG);
    }

    public static Result empty(String msg) {
        return new Result(CODE_EMPTY, msg, null);
    }

    public static Result empty() {
        return empty(CODE_EMPTY_MSG);
    }

    public boolean isOk() {
        return CODE_OK == this.code;
    }

    public boolean isEmpty() {
        return CODE_EMPTY == this.code;
    }

    public final static int CODE_OK = 200;
    public final static int CODE_FAIL = 400;
    public final static int CODE_EMPTY = 300;
    public final static String CODE_OK_MSG = "ok";
    public final static String CODE_FAIL_MSG = "fail";
    public final static String CODE_EMPTY_MSG = "未找到相关数据";
}

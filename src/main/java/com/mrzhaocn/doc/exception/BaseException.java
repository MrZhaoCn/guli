package com.mrzhaocn.doc.exception;

import lombok.Data;

@Data
public class BaseException extends Exception{
    private int code;
    private String msg;
    public BaseException(int code, String msg) {
        super();
        this.code = code;
        this.msg = msg;
    }
}

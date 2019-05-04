package com.codebox.codetemplate.core.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommonException extends Exception {

    private Integer code;
    private String msg;

    public CommonException(Integer code, String msg) {
        super(msg);
        this.msg = msg;
        this.code = code;
    }

    public CommonException(Integer code, String msg, Throwable cause) {
        super(msg, cause);
        this.msg = msg;
        this.code = code;
    }

}

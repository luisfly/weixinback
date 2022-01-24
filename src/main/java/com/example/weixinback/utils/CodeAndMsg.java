package com.example.weixinback.utils;

public enum CodeAndMsg {
    SUCCESS(20000, "SUCCESS"),
    METHODFAIL(21000, "ENCOUNTER AN ERROR WHEN EXECUTE METHOD"),
    UNKNOWECEPTION(22000, "UNKNOWECEPTION"),
    SQLIDNOTEXIST(30001, "SQLIDNOTEXIST"),
    REPEATERROR(30002, "REPEATERROR"),
    ILLEAGETOKEN(50008, "ILLEAGETOKEN"),
    OTHERCLIENTLOGIN(50012, "OTHERCLIENTLOGIN"),
    TOKENEXPIRED(50014, "TOKENEXPIRED"),
    PASSWORDERROR(50015, "PASSWORDERROR");

    private int code;
    private String msg;

    CodeAndMsg(int code, String msg) {
        this.code= code;
        this.msg = msg;
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
}

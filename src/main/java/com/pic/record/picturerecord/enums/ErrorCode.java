package com.pic.record.picturerecord.enums;

/**
 * description:
 *
 * @author chentong
 * @version 1.0
 * @date 2020/4/22 15:56
 */
public enum ErrorCode {

    UPLOAD_ERROR(3000, "upload.error");
    private Integer code;

    private String message;

    ErrorCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public static String messageOf(Integer code) {
        for (ErrorCode errorCode : ErrorCode.values()) {
            if (errorCode.code.equals(code)) {
                return errorCode.message;
            }
        }
        return "";
    }

    public Integer code() {
        return this.code;
    }

    public String message() {
        return this.message;
    }
}

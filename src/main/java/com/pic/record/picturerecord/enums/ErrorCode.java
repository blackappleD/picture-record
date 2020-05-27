package com.pic.record.picturerecord.enums;

/**
 * description:
 *
 * @author chentong
 * @version 1.0
 * @date 2020/4/22 15:56
 */
public enum ErrorCode {

    UPLOAD_ERROR(3000, "3000"),

    HANDLE_EXIF(3001, "3001"),

    FILE_ERROR(3002, "3002");
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

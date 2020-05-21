package com.pic.record.picturerecord.dto.res;

import lombok.Data;

/**
 * description: FileSystemRes
 *
 * @author chentong
 * @version 1.0
 * @date 2019/11/19 8:43
 */
@Data
public class FileSystemRes {

    private String url;

    private String md5;

    private String path;

    private String domain;

    private String scene;

    private int size;

    private int mtime;

    private String scenes;

    private String retmsg;

    private int retcode;

    private String src;
}

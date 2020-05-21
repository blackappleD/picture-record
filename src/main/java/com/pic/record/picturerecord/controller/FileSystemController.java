package com.pic.record.picturerecord.controller;

import com.pic.record.picturerecord.dto.DataResponse;
import com.pic.record.picturerecord.dto.res.FileSystemRes;
import com.pic.record.picturerecord.service.FileSystemService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * description:
 *
 * @author chentong
 * @version 1.0
 * @date 2020/5/21 9:51
 */
@RestController
@Api(value = "文件系统", tags = "文件系统")
@RequestMapping(value = "/file")
public class FileSystemController {

    @Resource
    private FileSystemService fileSystemService;

    @RequestMapping(value = "/upload")
    public DataResponse<FileSystemRes> upload() {

    }
}

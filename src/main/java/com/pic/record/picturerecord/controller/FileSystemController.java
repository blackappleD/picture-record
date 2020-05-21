package com.pic.record.picturerecord.controller;

import com.pic.record.picturerecord.dto.DataResponse;
import com.pic.record.picturerecord.dto.res.FileSystemRes;
import com.pic.record.picturerecord.service.FileSystemService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.PostConstruct;
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

    @PostMapping(value = "/upload")
    public DataResponse<FileSystemRes> upload(MultipartFile file,
                                              @RequestParam(required = false) @ApiParam(value = "文件存储path") String savePath) {
        return DataResponse.of(fileSystemService.upload(file, savePath));
    }
}

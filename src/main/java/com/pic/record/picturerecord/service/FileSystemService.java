package com.pic.record.picturerecord.service;

import com.pic.record.picturerecord.dto.res.FileSystemRes;
import org.springframework.web.multipart.MultipartFile;

import java.time.Instant;

/**
 * description:
 *
 * @author chentong
 * @version 1.0
 * @date 2020/5/21 9:52
 */
public interface FileSystemService {

    FileSystemRes upload(MultipartFile file, String savePath, Instant shotTime, String shotPlace);



}

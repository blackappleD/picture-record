package com.pic.record.picturerecord.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.pic.record.picturerecord.dto.req.PicIndexReqDTO;
import com.pic.record.picturerecord.dto.res.FileSystemRes;
import com.pic.record.picturerecord.entity.ImageExifInfo;
import com.pic.record.picturerecord.entity.PicIndex;
import com.pic.record.picturerecord.enums.ErrorCode;
import com.pic.record.picturerecord.exception.CommonException;
import com.pic.record.picturerecord.service.FileSystemService;
import com.pic.record.picturerecord.service.PicIndexService;
import com.pic.record.picturerecord.utils.FileUtils;
import okhttp3.*;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;

/**
 * description:
 *
 * @author chentong
 * @version 1.0
 * @date 2020/5/21 9:54
 */
@Service
public class FileSystemServiceImpl implements FileSystemService {

    @Value("${file.system.prefix}")
    private String prefix;

    private static final String path = "/upload";

    @Resource
    private PicIndexService picIndexService;

    @Override
    public FileSystemRes upload(MultipartFile file, String savePath, PicIndexReqDTO picIndexReqDTO) {

        String result = null;
        FileSystemRes res = null;
        try {
            OkHttpClient httpClient = new OkHttpClient();
            MultipartBody.Builder builder = new MultipartBody.Builder().
                    setType(MultipartBody.FORM)
                    .addFormDataPart("file", file.getOriginalFilename(),
                            RequestBody.create(MediaType.parse("multipart/form-data;charset=utf-8"),
                                    file.getBytes()))
                    .addFormDataPart("output", "json");

            if (StringUtils.isNotBlank(savePath) && StringUtils.isNotEmpty(savePath)) {
                builder.addFormDataPart("path", "default/" + savePath);
            }
            MultipartBody multipartBody = builder.build();
            Request request = new Request.Builder()
                    .url(prefix + path)
                    .post(multipartBody)
                    .build();
            Response response = httpClient.newCall(request).execute();
            if (response.isSuccessful()) {
                ResponseBody body = response.body();
                if (body != null) {
                    result = body.string();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw new CommonException(ErrorCode.UPLOAD_ERROR);
        }
        if (StringUtils.isNotBlank(result)) {

            res = JSONObject.parseObject(result, FileSystemRes.class);
        }
        ImageExifInfo imageExifInfo = FileUtils.handleImage(file);
        PicIndex picIndex = new PicIndex(res, picIndexReqDTO, JSONObject.toJSONString(imageExifInfo));
        picIndexService.save(picIndex);
        return res;
    }
}

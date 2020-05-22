package com.pic.record.picturerecord.entity;

import com.alibaba.fastjson.JSONObject;
import com.drew.metadata.Metadata;
import com.pic.record.picturerecord.dto.res.FileSystemRes;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.time.Instant;

/**
 * description:
 *
 * @author chentong
 * @version 1.0
 * @date 2020/5/21 16:21
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class PicIndex extends BaseEntity {

    private String path;

    private String description;

    private Instant shotDate;

    private String shotPlace;

    private String imageExifInfo;

    public PicIndex() {

    }

    public PicIndex(FileSystemRes file, Instant shotDate, String shotPlace, String imageExifInfo) {
        if (null != shotDate) {
            this.shotDate = shotDate;
        }
        if (null != shotPlace) {
            this.shotPlace = shotPlace;
        }
        this.path = file.getPath();
        this.imageExifInfo = imageExifInfo;
    }

}

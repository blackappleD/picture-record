package com.pic.record.picturerecord.entity;

import com.pic.record.picturerecord.dto.req.PicIndexReqDTO;
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

    private String country;

    private String city;

    private String imageExifInfo;

    public PicIndex() {

    }

    public PicIndex(FileSystemRes file, PicIndexReqDTO picIndexReqDTO, String imageExifInfo) {
        if (null != picIndexReqDTO.getShotDate()) {
            this.shotDate = picIndexReqDTO.getShotDate();
        }
        if (null != picIndexReqDTO.getDescription()) {
            this.description = picIndexReqDTO.getDescription();
        }
        if (null != picIndexReqDTO.getCountry()) {
            this.country = picIndexReqDTO.getCountry();
        }
        if (null != picIndexReqDTO.getCity()) {

            this.city = picIndexReqDTO.getCity();
        }
        this.path = file.getPath();
        this.imageExifInfo = imageExifInfo;
    }

}

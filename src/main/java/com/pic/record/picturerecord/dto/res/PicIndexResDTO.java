package com.pic.record.picturerecord.dto.res;

import com.pic.record.picturerecord.entity.ImageExifInfo;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.time.Instant;

/**
 * description:
 *
 * @author chentong
 * @version 1.0
 * @date 2020/5/26 17:46
 */
@Data
@ApiModel
public class PicIndexResDTO {

    private String path;

    private String description;

    private Instant shotDate;

    private String shotPlace;

    private ImageExifInfo imageExifInfo;
}

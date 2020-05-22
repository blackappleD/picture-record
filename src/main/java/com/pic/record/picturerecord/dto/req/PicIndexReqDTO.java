package com.pic.record.picturerecord.dto.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.Instant;

/**
 * description:
 *
 * @author chentong
 * @version 1.0
 * @date 2020/5/22 11:22
 */
@Data
@ApiModel
public class PicIndexReqDTO {

    @ApiModelProperty(value = "图片描述")
    private String description;

    @ApiModelProperty(value = "拍摄日期")
    private Instant shotDate;

    @ApiModelProperty(value = "拍摄地点")
    private String shotPlace;
}

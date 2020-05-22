package com.pic.record.picturerecord.entity;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.Instant;

/**
 * description:
 *
 * @author chentong
 * @version 1.0
 * @date 2020/5/22 14:04
 */
@Data
public class ImageExifInfo {
//        dictionary : Exif IFD0  -->name : Make  -->desc : Canon

    @ApiModelProperty(value = "拍摄设备生产厂家")
    private String make;
//        dictionary : Exif IFD0  -->name : Model  -->desc : Canon EOS 6D Mark II

    @ApiModelProperty(value = "拍摄设备型号")
    private String model;
//        dictionary : Exif IFD0  -->name : Orientation  -->desc : Top, left side (Horizontal / normal)

    @ApiModelProperty(value = "拍摄角度")
    private String orientation;
    //        dictionary : Exif SubIFD  -->name : Exif Image Width  -->desc : 6240 pixels

    @ApiModelProperty(value = "宽")
    private String exifImageWidth;

    //        dictionary : Exif SubIFD  -->name : Exif Image Height  -->desc : 4160 pixels
    @ApiModelProperty(value = "高")
    private String exifImageHeight;
//        dictionary : Exif SubIFD  -->name : Lens Model  -->desc : EF24-105mm f/4L IS USM

    @ApiModelProperty(value = "镜头型号")
    private String lensModel;
//        dictionary : Exif SubIFD  -->name : Lens Specification  -->desc : 24-105mm

    @ApiModelProperty(value = "镜头参数")
    private String lensSpecification;
//        dictionary : Exif SubIFD  -->name : Shutter Speed Value  -->desc : 1/32 sec

    @ApiModelProperty(value = "快门速度")
    private String shutterSpeedValue;
//        dictionary : Exif SubIFD  -->name : Aperture Value  -->desc : f/4.0

    @ApiModelProperty(value = "光圈")
    private String apertureValue;

    //        dictionary : Exif SubIFD  -->name : ISO Speed Ratings  -->desc : 3200
    @ApiModelProperty(value = "ISO感光等级")
    private String isoSpeedRatings;
//        dictionary : Exif SubIFD  -->name : Date/Time Original  -->desc : 2020:04:01 15:49:46

    @ApiModelProperty(value = "拍摄时间")
    private Instant date;

}

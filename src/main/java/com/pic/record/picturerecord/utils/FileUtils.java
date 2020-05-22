package com.pic.record.picturerecord.utils;

import com.drew.imaging.ImageMetadataReader;
import com.drew.imaging.ImageProcessingException;
import com.drew.metadata.Metadata;
import com.pic.record.picturerecord.entity.ImageExifInfo;
import com.pic.record.picturerecord.enums.ErrorCode;
import com.pic.record.picturerecord.enums.ExifEnum;
import com.pic.record.picturerecord.exception.CommonException;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.time.Instant;
import java.util.Objects;
import java.util.UUID;

/**
 * description:
 *
 * @author chentong
 * @version 1.0
 * @date 2020/5/22 15:14
 */
public class FileUtils {

    public static ImageExifInfo handleImage(MultipartFile multipartFile) {

        // 获取文件名
        String fileName = multipartFile.getOriginalFilename();
        // 获取文件后缀
        String prefix = fileName.substring(fileName.lastIndexOf("."));
        // 用uuid作为文件名，防止生成的临时文件重复
        File tempFile = null;
        Metadata metadata = null;
        try {
            tempFile = File.createTempFile(UUID.randomUUID().toString(), prefix);
            multipartFile.transferTo(tempFile);
            metadata = ImageMetadataReader.readMetadata(Objects.requireNonNull(tempFile));
        } catch (IOException | ImageProcessingException e) {
            throw new CommonException(ErrorCode.UPLOAD_ERROR);
        }
        //程序结束时，删除临时文件
        tempFile.delete();
//        dictionary : Exif IFD0  -->name : Make  -->desc : Canon
//        dictionary : Exif IFD0  -->name : Model  -->desc : Canon EOS 6D Mark II
//        dictionary : Exif IFD0  -->name : Orientation  -->desc : Top, left side (Horizontal / normal)
//        dictionary : Exif SubIFD  -->name : Exif Image Width  -->desc : 6240 pixels
//        dictionary : Exif SubIFD  -->name : Exif Image Height  -->desc : 4160 pixels
//        dictionary : Exif SubIFD  -->name : Lens Model  -->desc : EF24-105mm f/4L IS USM
//        dictionary : Exif SubIFD  -->name : Lens Specification  -->desc : 24-105mm
//        dictionary : Exif SubIFD  -->name : Shutter Speed Value  -->desc : 1/32 sec
//        dictionary : Exif SubIFD  -->name : Aperture Value  -->desc : f/4.0
//        dictionary : Exif SubIFD  -->name : ISO Speed Ratings  -->desc : 3200
//        dictionary : Exif SubIFD  -->name : Date/Time Original  -->desc : 2020:04:01 15:49:46
        ImageExifInfo imageExifInfo = new ImageExifInfo();
        metadata.getDirectories().forEach(directory -> {
                    if ("Exif IFD0".equals(directory.getName())) {
                        directory.getTags().forEach(tag -> {
                            switch (ExifEnum.of(tag.getTagName())) {
                                case Make:
                                    imageExifInfo.setMake(tag.getDescription());
                                    break;
                                case Model:
                                    imageExifInfo.setModel(tag.getDescription());
                                    break;
                                case LensModel:
                                    imageExifInfo.setLensModel(tag.getDescription());
                                    break;
                                case Orientation:
                                    imageExifInfo.setOrientation(tag.getDescription());
                                    break;
                                case ApertureValue:
                                    imageExifInfo.setApertureValue(tag.getDescription());
                                    break;
                                case ExifImageWidth:
                                    imageExifInfo.setExifImageWidth(tag.getDescription());
                                    break;
                                case ExifImageHeight:
                                    imageExifInfo.setExifImageHeight(tag.getDescription());
                                    break;
                                case ISOSpeedRatings:
                                    imageExifInfo.setIsoSpeedRatings(tag.getDescription());
                                    break;
                                case DateTimeOriginal:
                                    imageExifInfo.setDate(Instant.parse(tag.getDescription()));
                                    break;
                                case LensSpecification:
                                    imageExifInfo.setLensSpecification(tag.getDescription());
                                    break;
                                case ShutterSpeedValue:
                                    imageExifInfo.setShutterSpeedValue(tag.getDescription());
                                    break;
                                default:
                                    break;
                            }
                        });
                    }
                }
        );
        return imageExifInfo;
    }
}

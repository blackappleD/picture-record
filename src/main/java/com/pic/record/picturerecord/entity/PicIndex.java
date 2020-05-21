package com.pic.record.picturerecord.entity;

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
public class PicIndex extends BaseEntity{

    private String path;

    private String description;

    private Instant shotDate;

    public PicIndex(){

    }
    public PicIndex(FileSystemRes file){
        this.path = file.getPath();
    }

}

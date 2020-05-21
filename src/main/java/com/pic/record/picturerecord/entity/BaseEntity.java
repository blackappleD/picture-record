package com.pic.record.picturerecord.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.Instant;

/**
 * description:
 *
 * @author chentong
 * @version 1.0
 * @date 2020/4/20 15:54
 */
@Data
@ApiModel
public class BaseEntity {

    @ApiModelProperty(hidden = true)
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @JsonIgnore
    @TableField(value = "created_at", fill = FieldFill.INSERT)
    private Instant createdAt;

    @JsonIgnore
    @TableField(value = "updated_at", fill = FieldFill.INSERT, update = "NOW()")
    private Instant updatedAt;

    @JsonIgnore
    @TableLogic
    @TableField(value = "flag",  fill = FieldFill.INSERT)
    private Integer flag;
}

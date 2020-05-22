package com.pic.record.picturerecord.controller;

import com.pic.record.picturerecord.dto.DataResponse;
import com.pic.record.picturerecord.dto.PageReqDTO;
import com.pic.record.picturerecord.dto.PageResponse;
import com.pic.record.picturerecord.dto.req.PicIndexReqDTO;
import com.pic.record.picturerecord.entity.PicIndex;
import com.pic.record.picturerecord.service.PicIndexService;
import com.pic.record.picturerecord.utils.BeanCopyUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.Arrays;

/**
 * description:
 *
 * @author chentong
 * @version 1.0
 * @date 2020/5/22 9:18
 */
@RestController
@Api(value = "图片", tags = "图片")
@RequestMapping(value = "/pic")
@Validated
public class PicIndexController {

    @Resource
    private PicIndexService picIndexService;

    @GetMapping(value = "/page")
    @ApiOperation(value = "分页获取图片列表")
    public PageResponse<PicIndex> getPicIndexes(@Valid PageReqDTO pageReqDTO) {
        return PageResponse.of(picIndexService.page(pageReqDTO.of()));
    }

    @DeleteMapping
    @ApiOperation(value = "根据id批量删除图片")
    public <T> DataResponse<T> removePicIndex(@RequestParam Integer[] picId) {
        if (picId.length > 0) {
            picIndexService.removeByIds(Arrays.asList(picId));
        }
        return DataResponse.success();
    }

    @PutMapping(value = "/{picId}")
    @ApiOperation(value = "更新图片描述等")
    public <T> DataResponse<T> updatePicIndex(@PathVariable Integer picId,
                                              @RequestBody PicIndexReqDTO reqDTO) {

        PicIndex picIndex = picIndexService.getById(picId);
        BeanUtils.copyProperties(reqDTO, picIndex, BeanCopyUtils.getNullPropertyNames(reqDTO));
        picIndexService.updateById(picIndex);
        return DataResponse.success();
    }

    @GetMapping("/{picId}")
    @ApiOperation(value = "根据id获取图片详情")
    public DataResponse<PicIndex> getPicIndex(@PathVariable Integer picId) {

        return DataResponse.of(picIndexService.getById(picId));
    }
}

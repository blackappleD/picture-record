package com.pic.record.picturerecord.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pic.record.picturerecord.entity.PicIndex;
import com.pic.record.picturerecord.mapper.PicIndexMapper;
import com.pic.record.picturerecord.service.PicIndexService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * description:
 *
 * @author chentong
 * @version 1.0
 * @date 2020/5/21 16:50
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class PicIndexServiceImpl extends ServiceImpl<PicIndexMapper, PicIndex> implements PicIndexService {
}

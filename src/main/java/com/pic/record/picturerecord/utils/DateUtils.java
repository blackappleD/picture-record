package com.pic.record.picturerecord.utils;

import org.springframework.util.Assert;

import javax.swing.plaf.PanelUI;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

/**
 * description:
 *
 * @author chentong
 * @version 1.0
 * @date 2020/5/22 17:07
 */
public class DateUtils {

    public static Instant convertTimeToInstantOnUtc(String time) {
        Assert.notNull(time, "time is null");
        DateTimeFormatter ftf = DateTimeFormatter.ofPattern("yyyy:MM:dd HH:mm:ss");
        LocalDateTime parse = LocalDateTime.parse(time, ftf);
        return LocalDateTime.from(parse).atZone(ZoneId.of("UTC")).toInstant();
    }


}

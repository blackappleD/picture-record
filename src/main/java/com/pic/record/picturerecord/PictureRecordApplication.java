package com.pic.record.picturerecord;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties
public class PictureRecordApplication {

    public static void main(String[] args) {
        SpringApplication.run(PictureRecordApplication.class, args);
    }

}

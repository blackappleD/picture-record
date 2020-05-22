package com.pic.record.picturerecord.enums;

/**
 * description:
 *
 * @author chentong
 * @version 1.0
 * @date 2020/5/22 16:21
 */
public enum ExifEnum {
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
    Make("Make"),
    Model("Model"),
    Orientation("Orientation"),
    ExifImageWidth("Exif Image Width"),
    ExifImageHeight("Exif Image Height"),
    LensModel("Lens Model"),
    LensSpecification("Lens Specification"),
    ShutterSpeedValue("Shutter Speed Value"),
    ApertureValue("Aperture Value"),
    ISOSpeedRatings("ISO Speed Ratings"),
    DateTimeOriginal("Date/Time Original"),
    Unknown("");

    private String tag;

    ExifEnum(String tag) {
        this.tag = tag;
    }

    public String getTag() {
        return this.tag;
    }

    public static ExifEnum of(String tagName) {
        for (ExifEnum exif : ExifEnum.values()) {
            if (exif.tag.equals(tagName)) {
                return exif;
            }
        }
        return Unknown;
    }
}

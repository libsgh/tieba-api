package com.github.libsgh.tieba.model;

public enum WatermarkType {
	NO_WATERMARK        (1039999), //无水印
    TIEBA_WATERMARK     (1039998), //贴吧水印
    PERSONAL_WATERMARK  (1030001), //我的水印，无须购买也可使用
    DECADE_WATERMARK    (1030002); //十年有我，无须购买也可使用

    private int code;

    private WatermarkType(int _code) {
        this.code = _code;
    }

    public int getCode() {
        return code;
    }
}

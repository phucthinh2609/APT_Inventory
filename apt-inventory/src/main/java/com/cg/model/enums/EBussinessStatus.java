package com.cg.model.enums;

public enum EBussinessStatus {
    IN_STOCK("Còn Hàng"),
    OUT_OF_STOCK("Tạm Hết Hàng"),
    STOP_SELLING("Ngừng Kinh Doanh");

    private final String value;

    EBussinessStatus(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}

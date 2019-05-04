package com.codebox.codetemplate.domain.enums;

public enum OrderStatus implements CodeBaseEnum {

    CREATE(0, "创建"),
    PAYING(1, "支付中"),
    PROGRESS(2, "支付成功"),
    FAILED(3, "支付失败"),
    REVERSED(4, "取消订单");

    private int value;
    private String desc;

    OrderStatus(int value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    public int getValue() {
        return value;
    }

    public String getDesc() {
        return desc;
    }

    @Override
    public int code() {
        return value;
    }
}

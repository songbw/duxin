package com.jiannei.duxin.dto;

public enum UserTypeEnum {
    ADMIN(1), DEALER(2), WORKER(3),CUSTOMER(4);

    private Integer value;

    private UserTypeEnum(int value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
}

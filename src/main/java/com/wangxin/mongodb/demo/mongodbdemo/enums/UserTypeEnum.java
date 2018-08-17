package com.wangxin.mongodb.demo.mongodbdemo.enums;


import org.apache.commons.lang3.StringUtils;

/**
 * @Author:jzwx
 * @Desicription: 用户类型枚举
 * @Date:Created in 2018-08-15 10:14
 * @Modified By:
 */
public enum UserTypeEnum {
    ADMINTOR("1", "管理员"),

    NORMAL("2", "普通用户");

    private final String code;

    private final String desc;


    UserTypeEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    /**
     * 根据枚举值获取枚举
     * @param code
     * @return
     */
    public static UserTypeEnum getByCode(String code) {
        for (UserTypeEnum item : values()) {
            if (StringUtils.equals(item.code, code)) {
                return item;
            }
        }
        return null;
    }
}

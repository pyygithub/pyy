package com.thtf.generator.model;


import lombok.Data;

/**
 * ========================
 * 字段
 * Author：pyy
 * Date：2019-9-25 16:12:59
 * Version: v1.0
 * ========================
 */
@Data
public class Column {

    /** 名称 */
    private String name;
    /** 表名称 */
    private String tableName;
    /** 数据类型 */
    private String dataType;
    /** 是否可空 */
    private boolean isNullable;
    /** 默认值 */
    private String defaultValue;
    /** 长度 */
    private String length;
    /** 小数位 */
    private String precision;
    /** 描述 */
    private String description;
}


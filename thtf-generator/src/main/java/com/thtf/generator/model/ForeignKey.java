package com.thtf.generator.model;

import lombok.Data;

/**
 * ========================
 * 外键
 * Author：pyy
 * Date：2019-9-25 16:12:56
 * Version: v1.0
 * ========================
 */
@Data
public class ForeignKey {

    /** 外键名称 */
    private String fkName;

    /** 主键表名称 */
    private String pkTableName;

    /** 主键列名称 */
    private String pkColumnName;

    /** 外键表名称 */
    private String fkTableName;

    /** 外键列名称 */
    private String fkColumnName;
}

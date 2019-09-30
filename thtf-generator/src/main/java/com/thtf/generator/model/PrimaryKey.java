package com.thtf.generator.model;

import lombok.Data;

/**
 * ========================
 * 主键
 * Author：pyy
 * Date：2019-9-25 16:13:37
 * Version: v1.0
 * ========================
 */
@Data
public class PrimaryKey {

    /** 名称 */
    private String name;
    /** 所属表名称 */
    private String tableName;
    /** 字段 */
    private String cloumn;
}

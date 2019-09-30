package com.thtf.generator.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * ========================
 * 数据表
 * Author：pyy
 * Date：2019-9-25 16:14:37
 * Version: v1.0
 * ========================
 */
@Data
public class Table {

    /** 名称 */
    private String name;
    /** 描述 */
    private String description;
    /** 表空间 */
    private String tablespace;
    /** 索引字段列表 */
    private List<Column> columns = new ArrayList<Column>();
}

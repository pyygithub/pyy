package com.thtf.generator.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;


/**
 * ========================
 * 索引
 * Author：pyy
 * Date：2019-9-25 16:12:53
 * Version: v1.0
 * ========================
 */
@Data
public class Index {
    
    /** 名称 */
    private String name;
    /** 所属类型 */
    private String indexType;
    /** 所属表名称 */
    private String tableName;
    /** 是否唯一索引 */
    private boolean unique;
    /** 字段列表 */
    private List<String> cloumns = new ArrayList<String>();

    public void addCloumn(String cloumn) {
        this.cloumns.add(cloumn);
    }
}

package com.thtf.generator.model;

import lombok.Data;

/**
 * ========================
 * 存储过程
 * Author：pyy
 * Date：2019-9-25 16:14:08
 * Version: v1.0
 * ========================
 */
@Data
public class Procedure {
    
    /** 名称 */
    private String name;
    
    /** 描述 */
    private String description;
    
    /** 内容定义 */
    private String definition;
}

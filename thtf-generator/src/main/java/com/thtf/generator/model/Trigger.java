package com.thtf.generator.model;

import lombok.Data;

/**
 * ========================
 * 触发器
 * Author：pyy
 * Date：2019-9-25 16:14:58
 * Version: v1.0
 * ========================
 */
@Data
public class Trigger {
    
    /** 触发器名称 */
    private String name;
    
    /** 触发器类型 */
    private String triggerType;
    
    /** 触发器事件类型 */
    private String eventType;
    
    /** 触发器事件描述 */
    private String description;
    
    /** 触发器事件内容定义 */
    private String definition;
}

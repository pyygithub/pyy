package com.thtf.generator.vo;

import lombok.Data;

/**
 * ========================
 * 查询参数封装
 * Author：pyy
 * Date：2019-9-25 16:22:22
 * Version: v1.0
 * ========================
 */
@Data
public class RequestParam extends ConnParam {

	private static final long serialVersionUID = 1L;
	
	private String tableName;
}

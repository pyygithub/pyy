package com.thtf.generator.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * ========================
 * 数据库连接参数封装
 * Author：pyy
 * Date：2019-9-25 16:07:53
 * Version: v1.0
 * ========================
 */
@Data
public class ConnParam implements Serializable {

	private static final long serialVersionUID = 1L;
	
	/**
     * 数据库类型
     */
    private String dbType;
    /**
     * 数据库地址
     */
    private String host;
    /**
     * 数据库端口
     */
    private int port;
    /**
     * 数据库实例名
     */
    private String dbName;
    /**
     * 用户名
     */
    private String userName;
    /**
     * 密码
     */
    private String password;
    
    
    public ConnParam() {}
    
    /**
     * @param host
     * @param port
     * @param dbName
     * @param userName
     * @param password
     */
    public ConnParam(String dbType, String host, int port, String dbName, String userName, String password) {
        super();
        this.dbType = dbType;
        this.host = host;
        this.port = port;
        this.dbName = dbName;
        this.userName = userName;
        this.password = password;
    }

}
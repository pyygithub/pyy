package com.thtf.generator.dao;

import com.thtf.generator.common.exception.DAOException;
import com.thtf.generator.model.*;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

/**
 * ========================
 * 数据库元信息查询接口
 * Author：pyy
 * Date：2019-9-25 16:23:28
 * Version: v1.0
 * ========================
 */
public interface IDatabaseDAO {
	
    /**
     * 通用查询方法
     * @param sql 要查询的sql语句
     * @param params 查询条件数组
     * @return
     * @throws DAOException
     */
	List<Map<String, String>> query(String sql, String[] params) throws DAOException;
	
	/**
     * 查询表集合
     * @return
     * @throws DAOException
     */
	List<Table> getTables() throws DAOException;
	
	/**
     * 查询表的字段集
     * @param tableName
     * @return
     * @throws DAOException
     */
	List<Column> getColumns(String tableName) throws DAOException;
	
	/**
     * 查询主键集
     * @param tableName
     * @return
     * @throws DAOException
     */
	List<PrimaryKey> getPrimaryKeys(String tableName) throws DAOException;
	
	/**
     * 查询外键集
     * @param tableName
     * @return
     * @throws DAOException
     */
	List<ForeignKey> getForeignKeys(String tableName) throws DAOException;
	
	/**
     * 查询索引集
     * @return 
     * @throws DAOException
     */
	List<Index> getIndexes(String tableName) throws DAOException;
	
	/**
     * 查询触发器集
     * @param tableName
     * @return
     * @throws DAOException
     */
	List<Trigger> getTriggers(String tableName) throws DAOException;
	
	/**
     * 打开数据库连接
     */
	Connection openConnection() throws DAOException;
	
	/**
     * 关闭数据库连接
     */
	void closeConnection() throws DAOException;
}

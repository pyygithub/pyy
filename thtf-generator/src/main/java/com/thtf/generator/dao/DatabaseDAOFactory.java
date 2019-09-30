package com.thtf.generator.dao;

import com.thtf.generator.common.constants.DBMSConstants;
import com.thtf.generator.dao.impl.CommonDatabaseDAOImpl;
import com.thtf.generator.dao.impl.MySql5DatabaseDAO;
import com.thtf.generator.dao.sql.DatabaseType;
import com.thtf.generator.vo.ConnParam;

/**
 * ========================
 * 查询器生成工厂
 * Author：pyy
 * Date：2019-9-25 16:22:57
 * Version: v1.0
 * ========================
 */
public class DatabaseDAOFactory {

	public static IDatabaseDAO getDAO(ConnParam connParam) {
		String upperCaseDbName = connParam.getDbType().toUpperCase();
		
		if (upperCaseDbName.contains(DBMSConstants.ORACLE)) {
			return new CommonDatabaseDAOImpl(connParam, DatabaseType.Oracle);
		}  else if (upperCaseDbName.contains(DBMSConstants.SQL_SERVER) || upperCaseDbName.contains(DBMSConstants.SQLSERVER)) {
			return new CommonDatabaseDAOImpl(connParam, DatabaseType.MSSQLServer);
		} else if (upperCaseDbName.contains(DBMSConstants.MYSQL)) {
			return new MySql5DatabaseDAO(connParam, DatabaseType.MySql5);
		}
		return new MySql5DatabaseDAO(connParam, DatabaseType.MySql5);
	}
}

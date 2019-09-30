package com.thtf.generator.dao.impl;

import com.thtf.generator.common.exception.DAOException;
import com.thtf.generator.dao.sql.DatabaseType;
import com.thtf.generator.vo.ConnParam;

import java.util.List;
import java.util.Map;

/**
 * MySQL数据库元信息查询
 * @author Louis
 * @date Nov 10, 2018
 */
public class MySql5DatabaseDAO extends CommonDatabaseDAOImpl {

	public MySql5DatabaseDAO(ConnParam connParam, DatabaseType dbType) {
		super(connParam, dbType);
	}

	@Override
	protected String getQuerySql(String sqlKey) throws DAOException {
		return super.getQuerySql(sqlKey);
	}

	@Override
	public List<Map<String, String>> query(String sql, String[] params)
			throws DAOException {
		String[] realParams;
		if (params == null) {
			realParams = new String[] {connParam.getDbName()};
		} else {
			realParams = new String[params.length + 1];
			realParams[0] = connParam.getDbName();
			for (int i = 0; i < params.length; i++) {
				realParams[i + 1] = params[i];
			}
		}
		return super.query(sql, realParams);
	}
}

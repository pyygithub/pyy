package com.thtf.generator.service.impl;

import com.thtf.generator.common.exception.DAOException;
import com.thtf.generator.dao.DatabaseDAOFactory;
import com.thtf.generator.dao.IDatabaseDAO;
import com.thtf.generator.model.*;
import com.thtf.generator.service.DatabaseService;
import com.thtf.generator.vo.ConnParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


/**
 * ========================
 * 数据库元信息查询服务service实现类
 * Author：pyy
 * Date：2019-9-25 16:37:34
 * Version: v1.0
 * ========================
 */
@Slf4j
@Service
public class DatabaseServiceImpl implements DatabaseService {

	@Override
	public List<Map<String, String>> query(ConnParam connParam, String sql, String[] params) {
		List<Map<String, String>> maps = new ArrayList<Map<String, String>>();
		if(connParam == null) {
			return maps;
		}
		try {
		    IDatabaseDAO dao = DatabaseDAOFactory.getDAO(connParam);
		    long start = System.currentTimeMillis();
		    dao.openConnection();
		    maps = dao.query(sql, params);
		    dao.closeConnection();
		    long end = System.currentTimeMillis();
		    log.info("### 反向获取数据库表信息耗时：{} 毫秒 ###",(end - start));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return maps;
	}

	@Override
	public List<Table> getTables(ConnParam connParam) {
		List<Table> tables = new ArrayList<Table>();
		if(connParam == null) {
			return tables;
		}
		try {
		    IDatabaseDAO dao = DatabaseDAOFactory.getDAO(connParam);
		    long start = System.currentTimeMillis();
		    dao.openConnection();
		    tables = dao.getTables();
		    dao.closeConnection();
		    long end = System.currentTimeMillis();
			log.info("### 反向获取数据库表信息耗时：{} 毫秒 ###",(end - start));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tables;
	}

	@Override
	public List<Column> getColumns(ConnParam connParam, String tableName) {
		List<Column> columns = new ArrayList<Column>();
		if(connParam == null) {
			return columns;
		}
		try {
		    IDatabaseDAO dao = DatabaseDAOFactory.getDAO(connParam);
			long start = System.currentTimeMillis();
		    dao.openConnection();
		    columns = dao.getColumns(tableName);
		    dao.closeConnection();
			long end = System.currentTimeMillis();
			log.info("### 反向获取数据库表列信息耗时：{} 毫秒 ###",(end - start));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return columns;
	}

	@Override
	public List<PrimaryKey> getPrimaryKeys(ConnParam connParam, String tableName) {
		List<PrimaryKey> primaryKeys = new ArrayList<PrimaryKey>();
		if(connParam == null) {
			return primaryKeys;
		}
		try {
		    IDatabaseDAO dao = DatabaseDAOFactory.getDAO(connParam);
			long start = System.currentTimeMillis();
		    dao.openConnection();
		    primaryKeys = dao.getPrimaryKeys(tableName);
		    dao.closeConnection();
			long end = System.currentTimeMillis();
			log.info("### 反向获取数据库表主键信息耗时：{} 毫秒 ###",(end - start));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return primaryKeys;
	}

	@Override
	public List<ForeignKey> getForeignKeys(ConnParam connParam, String tableName) {
		List<ForeignKey> foreignKeys = new ArrayList<ForeignKey>();
		if(connParam == null) {
			return foreignKeys;
		}
		try {
		    IDatabaseDAO dao = DatabaseDAOFactory.getDAO(connParam);
			long start = System.currentTimeMillis();
		    dao.openConnection();
		    foreignKeys = dao.getForeignKeys(tableName);
		    dao.closeConnection();
			long end = System.currentTimeMillis();
			log.info("### 反向获取数据库表外键信息耗时：{} 毫秒 ###",(end - start));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return foreignKeys;
	}

	@Override
	public List<Index> getIndexes(ConnParam connParam, String tableName) {
		List<Index> indexes = new ArrayList<Index>();
		if(connParam == null) {
			return indexes;
		}
		try {
		    IDatabaseDAO dao = DatabaseDAOFactory.getDAO(connParam);
			long start = System.currentTimeMillis();
		    dao.openConnection();
		    indexes = dao.getIndexes(tableName);
			long end = System.currentTimeMillis();
			log.info("### 反向获取数据库表索引信息耗时：{} 毫秒 ###",(end - start));
		    dao.closeConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return indexes;
	}

	@Override
	public List<Trigger> getTriggers(ConnParam connParam, String tableName) {
		List<Trigger> trigger = new ArrayList<Trigger>();
		if(connParam == null) {
			return trigger;
		}
		try {
		    IDatabaseDAO dao = DatabaseDAOFactory.getDAO(connParam);
			long start = System.currentTimeMillis();
		    dao.openConnection();
		    trigger = dao.getTriggers(tableName);
			long end = System.currentTimeMillis();
			log.info("### 反向获取数据库表触发器信息耗时：{} 毫秒 ###",(end - start));
		    dao.closeConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return trigger;
	}

	@Override
	public boolean canConnect(ConnParam connParam) {
		IDatabaseDAO dao = DatabaseDAOFactory.getDAO(connParam);
		if (dao == null) {
			return false;
		}
		try {
			dao.openConnection();
			log.info("### 数据库连接成功! ###");
			return true;
		} catch (Exception e) {
			log.info("### 数据库连接失败,请检查端口号、用户名或密码 !###");
		} finally {
			try {
				dao.closeConnection();
			} catch (DAOException e) {
				e.printStackTrace();
			}
		}
		return false;
	}
}

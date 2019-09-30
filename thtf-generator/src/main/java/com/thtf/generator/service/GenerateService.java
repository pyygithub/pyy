package com.thtf.generator.service;


import com.thtf.generator.model.Table;
import com.thtf.generator.vo.ConnParam;
import com.thtf.generator.vo.GenerateModel;

import java.io.IOException;
import java.util.List;


/**
 * ========================
 * 代码生成服务service接口
 * Author：pyy
 * Date：2019-9-28 16:50:17
 * Version: v1.0
 * ========================
 */
public interface GenerateService {

	/**
	 * 是否可以连接
	 * @param connParam
	 * @return
	 */
	boolean testConnection(ConnParam connParam);

	/**
	 * 反向查找数据表
	 * @param connParam
	 * @return
	 */
	List<Table> getTables(ConnParam connParam);

	/**
	 * 获取代码生成数据模型
	 * @param generateModel
	 * @return
	 */
	GenerateModel getGenerateModel(GenerateModel generateModel);

	/**
	 * 生成代码文件
	 * @param generateModel
	 * @return
	 * @throws IOException 
	 */
	boolean generateModels(GenerateModel generateModel) throws Exception;


}

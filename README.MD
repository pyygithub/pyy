### 项目介绍

thtf代码生成器，可以通过界面配置快速生成包括 model，dao，service，controller 以及vue页面的相关代码。


### 软件架构

#### [](https://gitee.com/liuge1988/kitty-generator#%E5%90%8E%E7%AB%AF%E6%9E%B6%E6%9E%84)后端架构

##### [](https://gitee.com/liuge1988/kitty-generator#%E5%BC%80%E5%8F%91%E7%8E%AF%E5%A2%83)开发环境

*   IDE : IDEA
*   JDK : JDK1.8.x
*   Maven : Maven 3.6.x
*   MySQL: MySQL 5.7.x

##### 技术选型

*   核心框架：Spring Boot 2.x
*   视图框架：Spring MVC 5.x
*   持久层框架：MyBatis 3.x
*   模板技术：beetl 1.1.68
*   XML解析：dom4j 1.6.x
*   JSON工具：fastjson 1.2.x

#### 前端架构
##### 开发环境
*   IDE : IntelliJ IDEA
*   NODE: Node 8.9.x
*   NPM : NPM 6.4.x

##### 技术选型

*   前端框架：Vue 2.x
*   页面组件：Element 2.x
*   状态管理：Vuex 2.x
*   后台交互：axios 0.18.x
*   图标使用：Font Awesome 4.x

### 使用说明
1. 配置数据源
![](https://upload-images.jianshu.io/upload_images/11464886-b94496a0482d11d7.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)
【测试】连接，【保存】

2. 单击 【单表查询】 - 【选择要生成的表】
![](https://upload-images.jianshu.io/upload_images/11464886-4513feb3b07f7ef4.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

![](https://upload-images.jianshu.io/upload_images/11464886-ffd27446086c1dc2.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

3. 配置包名和生成代码位置，【生成代码】
![](https://upload-images.jianshu.io/upload_images/11464886-153ebb875c8630b0.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

### 
代码样例

#### Controller 代码样例
```
package com.thtf.output.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.louis.kitty.core.http.HttpResult;
import com.louis.kitty.core.page.PageRequest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import com.thtf.output.model.Resources;
import com.thtf.output.service.ResourcesService;

/**
 * ---------------------------
 * 资源 (ResourcesController)         
 * ---------------------------
 * 作者：  
 * 时间：  2019-09-30 10:30:42
 * 版本：  v1.0
 * ---------------------------
 */
@Api(value = "ResourcesController", description = "资源相关接口")
@RestController
@RequestMapping("/v1")
public class ResourcesController {

	@Autowired
	private ResourcesService resourcesService;

   /**
     * 保存资源
     * @param record
     * @return
     */
    @ApiOperation(value = "保存资源", notes = "保存资源接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "record", value = "资源对象", required = true, dataType = "Resources", paramType = "body")
    })
    @PostMapping("/resources")
    public Result save(@Valid @RequestBody ResourcesSaveOrUpdateVO record) {
        resourcesService.save(record);
        return Result.SUCCESS();
    }

   /**
     * 修改资源
     * @param id
     * @param record
     * @return
     */
    @ApiOperation(value = "修改资源", notes = "修改资源接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "资源ID", required = true, dataType = "String", paramType = "path"),
            @ApiImplicitParam(name = "record", value = "资源对象", required = true, dataType = "Resources", paramType = "body")
    })
    @PutMapping("/resources/{id}")
    public Result update(@Valid @PathVariable(value = "id") String id, @RequestBody ResourcesSaveOrUpdateVO record) {
        resourcesService.update(id, record);
        return Result.SUCCESS();
    }

    /**
     * 删除资源
     * @param id
     * @return
     */
	@ApiOperation(value = "修改资源", notes = "修改资源接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "资源ID", required = true, dataType = "String", paramType = "path")
    })
    @DeleteMapping("/resources/{id}")
    public Result delete(@Valid @PathVariable(value = "id") String id) {
        resourcesService.delete(id);
        return Result.SUCCESS();
    }

    /**
     * 根据主键查询
     * @param id
     * @return
     */
    @GetMapping("/resources")
    public Result<ResourcesVO> findById(@Valid @PathVariable(value = "id") String id) {
        ResourcesVO queryResult = resourcesService.findById(id);
        return Result.SUCCESS(queryResult);
    }

    /**
     * 资源分页模糊查询
     * @param page
     * @param size
     * @return
     */
    @ApiOperation(value = "外部数据源分页列表查询", notes = "外部数据源分页列表查询接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "当前页码", required = true, dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "size", value = "分页尺寸", required = true, dataType = "int", paramType = "query")
    })
    @GetMapping("/resourcess/page")
    public Result<QueryResult<ResourcesVO>> listByPageAndParam(ResourcesQueryConditionVO queryConditionVO,
                                     @RequestParam("page") Integer page,
                                     @RequestParam("size") Integer size) {
        QueryResult<ResourcesVO> queryResult = labelService.listByPageAndParam(queryConditionVO, page, size);
        return Result.SUCCESS(queryResult);
    }
	
}
```
#### Service和ServiceImpl 代码样例
```
package com.thtf.output.service;

import com.thtf.output.model.Resources;

/**
 * ---------------------------
 * 资源 (ResourcesService)         
 * ---------------------------
 * 作者：  
 * 时间：  2019-09-30 10:30:42
 * 版本：  v1.0
 * ---------------------------
 */
public interface ResourcesService {
    /**
     * 资源保存
     *
     * @param ResourcesSaveOrUpdateVO
     */
	public void save(ResourcesSaveOrUpdateVO resourcesSaveOrUpdateVO);

	/**
     * 资源修改
     *
     * @param id
     * @param ResourcesSaveOrUpdateVO
     */
    public void update(String id, ResourcesSaveOrUpdateVO resourcesSaveOrUpdateVO);

    /**
     * 资源删除
     *
     * @param id
     */
	public void delete(String id);

    /**
     * 根据资源ID查询
     *
     * @param id
     */
	public ResourcesVO findById(String id);

    /**
     * 资源分页模糊查询
     * @param queryConditionVO
     * @param page
     * @param size
     * @return
     */
    public QueryResult<ResourcesVO> listByPageAndParam(ResourcesQueryConditionVO queryConditionVO, Integer page, Integer size);
}
```
ServiceImpl
```
package com.thtf.output.service.impl;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import tk.mybatis.mapper.entity.Example;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


import com.thtf.output.model.*;
import com.thtf.output.vo.*;
import com.thtf.output.dao.ResourcesMapper;

/**
 * ---------------------------
 * 资源 (ResourcesServiceImpl)         
 * ---------------------------
 * 作者：  
 * 时间：  2019-09-30 10:30:42
 * 版本：  v1.0
 * ---------------------------
 */
@Slf4j
@Service
@Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,timeout=36000,rollbackFor=Exception.class)
public class ResourcesServiceImpl implements ResourcesService {

	@Autowired
	private ResourcesMapper resourcesMapper;

    /**
     * 资源保存
     *
     * @param ResourcesSaveOrUpdateVO
     */
	@Override
	public void save(ResourcesSaveOrUpdateVO resourcesSaveOrUpdateVO) {
        // 保存资源
        Resources resourcesModel = new Resources();
        BeanUtils.copyProperties(resourcesSaveOrUpdateVO, resourcesModel);
        resourcesModel.setId(SnowflakeId.getId() + "");
        resourcesModel.setCreateId(UserUtil.getUserId());
        resourcesModel.setCreateName(UserUtil.getUsername());
        resourcesModel.setCreateTime(new Timestamp(System.currentTimeMillis()));
        resourcesModel.setDeleteFlag(Constants.UN_DELETED);

        resourcesMapper.insert(resourcesModel);
        log.info("### 资源保存成功 ###");
	}

	/**
     * 资源修改
     *
     * @param id
     * @param ResourcesSaveOrUpdateVO
     */
    @Override
    public void update(String id, ResourcesSaveOrUpdateVO resourcesSaveOrUpdateVO) {
        Resources resourcesModel = resourcesMapper.selectByPrimaryKey(id);
        if (resourcesModel == null) {
            throw new CustomException(ResultCode.RESULT_DATA_NONE, "资源");
        }

        // 修改
        BeanUtils.copyProperties(resourcesSaveOrUpdateVO, resourcesModel);
        resourcesModel.setUpdateId(UserUtil.getUserId());
        resourcesModel.setUpdateName(UserUtil.getUsername());
        resourcesModel.setUpdateTime(new Timestamp(System.currentTimeMillis()));

        resourcesMapper.updateByPrimaryKey(resourcesModel);
        log.info("### 资源修改成功 ###");
    }

   /**
    * 资源删除
    *
    * @param id
    */
	@Override
	public void delete(String id) {
	    Resources resourcesModel = resourcesMapper.selectByPrimaryKey(id);
        if (resourcesModel == null) {
            throw new CustomException(ResultCode.RESULT_DATA_NONE, "资源,id=" + id);
        }

		// 逻辑删除
        Resources resourcesModel = new Resources();
        resourcesModel.setId(id);
        resourcesModel.setUpdateId(UserUtil.getUserId());
        resourcesModel.setUpdateName(UserUtil.getUsername());
        resourcesModel.setUpdateTime(new Timestamp(System.currentTimeMillis()));
        resourcesModel.setDeleteFlag(Constants.DELETED);

        resourcesMapper.updateByPrimaryKeySelective(resourcesModel);
        log.info("### 资源逻辑删除成功 ###");
	}

   /**
    * 根据资源ID查询
    *
    * @param id
    */
	@Override
	public ResourcesVO findById(String id) {
		Resources resourcesModel = resourcesMapper.selectByPrimaryKey(id);
		if (resourcesModel == null) {
            throw new CustomException(ResultCode.RESULT_DATA_NONE, "资源,id=" + id);
        }
        log.info("### 资源查询成功, resources={}###", JSON.toJSONString(resources));
        // model转换vo
        ResourcesVO resourcesVO = new Resources();
        BeanUtils.copyProperties(resourcesModel, resourcesVO);
        log.info("### 资源Model转换VO成功， resourcesVO={}###", resourcesVO);
        return resourcesVO;
	}

    /**
     * 资源分页模糊查询
     * @param queryConditionVO
     * @param page
     * @param size
     * @return
     */
	@Override
    public QueryResult<ResourcesVO> listByPageAndParam(ResourcesQueryConditionVO queryConditionVO, Integer page, Integer size) {
        // 分页查询
        page = page == null || page <= 0 ? 1 : page;
        size = size == null || size <= 0 ? 10 : size;
        PageHelper.startPage(page, size);
        List<Resources> resourcesList = resourcesMapper.selectByPageAndParam(queryConditionVO);
        // 获取分页后数据
        PageInfo<Resources> pageInfo = new PageInfo<>(resourcesList);
        log.info("### 资源分页查询完毕,总条数：{} ###", pageInfo.getTotal());

        List<ResourcesVO> resourcesVOList = new ArrayList<>();
        // 补全数据
        resourcesList.forEach(resources -> {
            ResourcesVO resourcesVO = new ResourcesVO();
            BeanUtils.copyProperties(resources, resourcesVO);
            resourcesVOList.add(resourcesVO);
        });
        log.info("### 资源Model转换VO数据完毕###");

        // 封装需要返回的实体数据
        QueryResult queryResult = new QueryResult();
        queryResult.setTotal(pageInfo.getTotal());
        queryResult.setList(resourcesVOList);

        return queryResult;
    }
}

```

#### dao代码
```
package com.thtf.output.dao;

import java.util.List;

import com.thtf.output.model.Resources;
import tk.mybatis.mapper.common.Mapper;
import com.thtf.output.vo.*;
import com.thtf.output.model.*;

/**
 * ---------------------------
 * 资源 (ResourcesMapper)         
 * ---------------------------
 * 作者：  
 * 时间：  2019-09-30 10:30:42
 * 版本：  v1.0
 * ---------------------------
 */
public interface ResourcesMapper extends Mapper<Resources>{

    List<Resources> selectByPageAndParam(ResourcesQueryConditionVO queryConditionVO);
}
```
xxxMapper.xml
```
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="com.thtf.output.dao.ResourcesMapper">

  <resultMap id="BaseResultMap" type="com.thtf.output.model.Resources">
	<id column="ID" jdbcType="VARCHAR" property="id" />
	<result column="NAME" jdbcType="VARCHAR" property="name" />
	<result column="DEPT_CODE" jdbcType="VARCHAR" property="deptCode" />
	<result column="DEPT_NAME" jdbcType="VARCHAR" property="deptName" />
	<result column="TIME_SCOPE" jdbcType="VARCHAR" property="timeScope" />
	<result column="SPACE_SCOPE" jdbcType="VARCHAR" property="spaceScope" />
	<result column="FREQUENCY" jdbcType="VARCHAR" property="frequency" />
	<result column="DATA_FORMAT" jdbcType="VARCHAR" property="dataFormat" />
	<result column="DATA_ACCURACY" jdbcType="VARCHAR" property="dataAccuracy" />
	<result column="DATA_COUNT" jdbcType="NUMERIC" property="dataCount" />
	<result column="DATA_SIZE" jdbcType="VARCHAR" property="dataSize" />
	<result column="DATA_PROVIDER" jdbcType="VARCHAR" property="dataProvider" />
	<result column="PURPOSE_EXPLANATION" jdbcType="VARCHAR" property="purposeExplanation" />
	<result column="OUTER_DATASOURCE_ID" jdbcType="VARCHAR" property="outerDatasourceId" />
	<result column="INNER_DATASOURCE_ID" jdbcType="VARCHAR" property="innerDatasourceId" />
	<result column="STORAGE_MODE" jdbcType="VARCHAR" property="storageMode" />
	<result column="STATUS" jdbcType="VARCHAR" property="status" />
	<result column="CREATE_ID" jdbcType="VARCHAR" property="createId" />
	<result column="CREATE_NAME" jdbcType="VARCHAR" property="createName" />
	<result column="CREATE_TIME" jdbcType="DATE" property="createTime" />
	<result column="UPDATE_ID" jdbcType="VARCHAR" property="updateId" />
	<result column="UPDATE_NAME" jdbcType="VARCHAR" property="updateName" />
	<result column="UPDATE_TIME" jdbcType="DATE" property="updateTime" />
	<result column="DELETE_FLAG" jdbcType="VARCHAR" property="deleteFlag" />
  </resultMap>

  <select id="selectByPageAndParam" parameterType="com.thtf.output.vo.ResourcesQueryConditionVO" resultMap="BaseResultMap">
    select * from RESOURCES t
    where
        t.delete_flag = '0'
        <if test="name != null">
        <!-- 根据具体业务调整模糊查询条件 -->
        and t.name like '%'||#{name}||'%'
        </if>
    order by t.update_time desc, t.create_time desc
  </select>
  
</mapper>
```

#### Model
```
package com.thtf.output.model;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;

/**
 * ---------------------------
 * 资源 (Resources)         
 * ---------------------------
 * 作者：  
 * 时间：  2019-09-30 10:30:42
 * 版本：  v1.0
 * ---------------------------
 */
@Data
@Table(name = "RESOURCES")
public class Resources {

	/**  */
	@Id
	private String id;
	/** 名称 */
	private String name;
	/** 所属部门编码 */
	private String deptCode;
	/** 所属部门名称 */
	private String deptName;
	/** 时间范围 */
	private String timeScope;
	/** 空间范围 */
	private String spaceScope;
	/** 更新周期（频度） */
	private String frequency;
	/** 数据格式 */
	private String dataFormat;
	/** 数据精度 */
	private String dataAccuracy;
	/** 数据量（记录数） */
	private Double dataCount;
	/** 数据大小（KB/MB/GB...) */
	private String dataSize;
	/** 数据来源（提供人） */
	private String dataProvider;
	/** 用途说明（业务用途） */
	private String purposeExplanation;
	/** 外部数据源ID */
	private String outerDatasourceId;
	/** 内部数据源ID */
	private String innerDatasourceId;
	/** 存储形式 1：体内 2：体外 */
	private String storageMode;
	/** 01：维护中 02：已发布 03：已停用 */
	private String status;
	/** 创建人ID */
	private String createId;
	/** 创建人名称 */
	private String createName;
	/** 创建时间 */
	private java.util.Date createTime;
	/** 更新人ID */
	private String updateId;
	/** 更新人名称 */
	private String updateName;
	/** 更新时间 */
	private java.util.Date updateTime;
	/** 1：删除 0：正常 */
	private String deleteFlag;

}
```
#### VO
```
package com.thtf.output.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * ---------------------------
 * 资源 (Resources)         
 * ---------------------------
 * 作者：  
 * 时间：  2019-09-30 10:30:42
 * 版本：  v1.0
 * ---------------------------
 */
@Data
public class ResourcesVO {

	@ApiModelProperty("")
    private String id;
	@ApiModelProperty("名称")
    private String name;
	@ApiModelProperty("所属部门编码")
    private String deptCode;
	@ApiModelProperty("所属部门名称")
    private String deptName;
	@ApiModelProperty("时间范围")
    private String timeScope;
	@ApiModelProperty("空间范围")
    private String spaceScope;
	@ApiModelProperty("更新周期（频度）")
    private String frequency;
	@ApiModelProperty("数据格式")
    private String dataFormat;
	@ApiModelProperty("数据精度")
    private String dataAccuracy;
	@ApiModelProperty("数据量（记录数）")
    private Double dataCount;
	@ApiModelProperty("数据大小（KB/MB/GB...)")
    private String dataSize;
	@ApiModelProperty("数据来源（提供人）")
    private String dataProvider;
	@ApiModelProperty("用途说明（业务用途）")
    private String purposeExplanation;
	@ApiModelProperty("外部数据源ID")
    private String outerDatasourceId;
	@ApiModelProperty("内部数据源ID")
    private String innerDatasourceId;
	@ApiModelProperty("存储形式 1：体内2：体外")
    private String storageMode;
	@ApiModelProperty("01：维护中 02：已发布 03：已停用")
    private String status;
	@ApiModelProperty("创建人ID")
    private String createId;
	@ApiModelProperty("创建人名称")
    private String createName;
	@ApiModelProperty("创建时间")
    private java.util.Date createTime;
	@ApiModelProperty("更新人ID")
    private String updateId;
	@ApiModelProperty("更新人名称")
    private String updateName;
	@ApiModelProperty("更新时间")
    private java.util.Date updateTime;
	@ApiModelProperty("1：删除 0：正常")
    private String deleteFlag;

}
```

#### VUE代码
```
<template>
  <div class="container" style="width:99%;margin-top:-25px;">
	<!--工具栏-->
	<div class="toolbar" style="float:left;padding-top:10px;padding-left:15px;">
		<el-form :inline="true" :model="filters" :size="size">
			<el-form-item>
				<el-input v-model="filters.label" placeholder="名称"></el-input>
			</el-form-item>
			<el-form-item>
				<kt-button :label="$t('action.search')" perms="sys:resources:view" type="primary" @click="findPage(null)"/>
			</el-form-item>
			<el-form-item>
				<kt-button :label="$t('action.add')" perms="sys:resources:add" type="primary" @click="handleAdd" />
			</el-form-item>
		</el-form>
	</div>
	<!--表格内容栏-->
	<kt-table permsEdit="sys:resources:edit" permsDelete="sys:resources:delete"
		:data="pageResult" :columns="columns" 
		@findPage="findPage" @handleEdit="handleEdit" @handleDelete="handleDelete">
	</kt-table>
	<!--新增编辑界面-->
	<el-dialog :title="operation?'新增':'编辑'" width="40%" :visible.sync="editDialogVisible" :close-on-click-modal="false">
		<el-form :model="dataForm" label-width="80px" :rules="dataFormRules" ref="dataForm" :size="size">
			<el-form-item label="" prop="id"  v-if="dataForm.isPrimaryKey">
				<el-input v-model="dataForm.id" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="名称" prop="name"  v-if="dataForm.isPrimaryKey">
				<el-input v-model="dataForm.name" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="所属部门编码" prop="deptCode"  v-if="dataForm.isPrimaryKey">
				<el-input v-model="dataForm.deptCode" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="所属部门名称" prop="deptName"  v-if="dataForm.isPrimaryKey">
				<el-input v-model="dataForm.deptName" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="时间范围" prop="timeScope"  v-if="dataForm.isPrimaryKey">
				<el-input v-model="dataForm.timeScope" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="空间范围" prop="spaceScope"  v-if="dataForm.isPrimaryKey">
				<el-input v-model="dataForm.spaceScope" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="更新周期（频度）" prop="frequency"  v-if="dataForm.isPrimaryKey">
				<el-input v-model="dataForm.frequency" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="数据格式" prop="dataFormat"  v-if="dataForm.isPrimaryKey">
				<el-input v-model="dataForm.dataFormat" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="数据精度" prop="dataAccuracy"  v-if="dataForm.isPrimaryKey">
				<el-input v-model="dataForm.dataAccuracy" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="数据量（记录数）" prop="dataCount"  v-if="dataForm.isPrimaryKey">
				<el-input v-model="dataForm.dataCount" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="数据大小（KB/MB/GB...)" prop="dataSize"  v-if="dataForm.isPrimaryKey">
				<el-input v-model="dataForm.dataSize" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="数据来源（提供人）" prop="dataProvider"  v-if="dataForm.isPrimaryKey">
				<el-input v-model="dataForm.dataProvider" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="用途说明（业务用途）" prop="purposeExplanation"  v-if="dataForm.isPrimaryKey">
				<el-input v-model="dataForm.purposeExplanation" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="外部数据源ID" prop="outerDatasourceId"  v-if="dataForm.isPrimaryKey">
				<el-input v-model="dataForm.outerDatasourceId" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="内部数据源ID" prop="innerDatasourceId"  v-if="dataForm.isPrimaryKey">
				<el-input v-model="dataForm.innerDatasourceId" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="存储形式 1：体内
2：体外" prop="storageMode"  v-if="dataForm.isPrimaryKey">
				<el-input v-model="dataForm.storageMode" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="01：维护中 02：已发布 03：已停用" prop="status"  v-if="dataForm.isPrimaryKey">
				<el-input v-model="dataForm.status" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="创建人ID" prop="createId"  v-if="dataForm.isPrimaryKey">
				<el-input v-model="dataForm.createId" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="创建人名称" prop="createName"  v-if="dataForm.isPrimaryKey">
				<el-input v-model="dataForm.createName" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="创建时间" prop="createTime"  v-if="dataForm.isPrimaryKey">
				<el-input v-model="dataForm.createTime" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="更新人ID" prop="updateId"  v-if="dataForm.isPrimaryKey">
				<el-input v-model="dataForm.updateId" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="更新人名称" prop="updateName"  v-if="dataForm.isPrimaryKey">
				<el-input v-model="dataForm.updateName" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="更新时间" prop="updateTime"  v-if="dataForm.isPrimaryKey">
				<el-input v-model="dataForm.updateTime" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="1：删除 0：正常" prop="deleteFlag"  v-if="dataForm.isPrimaryKey">
				<el-input v-model="dataForm.deleteFlag" auto-complete="off"></el-input>
			</el-form-item>
		</el-form>
		<div slot="footer" class="dialog-footer">
			<el-button :size="size" @click.native="editDialogVisible = false">{{$t('action.cancel')}}</el-button>
			<el-button :size="size" type="primary" @click.native="submitForm" :loading="editLoading">{{$t('action.submit')}}</el-button>
		</div>
	</el-dialog>
  </div>
</template>

<script>
import KtTable from "@/views/Core/KtTable"
import KtButton from "@/views/Core/KtButton"
import { format } from "@/utils/datetime"
export default {
	components:{
			KtTable,
			KtButton
	},
	data() {
		return {
			size: 'small',
			filters: {
				label: ''
			},
			columns: [
				{prop:"id", label:"", minWidth:100},
				{prop:"name", label:"名称", minWidth:100},
				{prop:"deptCode", label:"所属部门编码", minWidth:100},
				{prop:"deptName", label:"所属部门名称", minWidth:100},
				{prop:"timeScope", label:"时间范围", minWidth:100},
				{prop:"spaceScope", label:"空间范围", minWidth:100},
				{prop:"frequency", label:"更新周期（频度）", minWidth:100},
				{prop:"dataFormat", label:"数据格式", minWidth:100},
				{prop:"dataAccuracy", label:"数据精度", minWidth:100},
				{prop:"dataCount", label:"数据量（记录数）", minWidth:100},
				{prop:"dataSize", label:"数据大小（KB/MB/GB...)", minWidth:100},
				{prop:"dataProvider", label:"数据来源（提供人）", minWidth:100},
				{prop:"purposeExplanation", label:"用途说明（业务用途）", minWidth:100},
				{prop:"outerDatasourceId", label:"外部数据源ID", minWidth:100},
				{prop:"innerDatasourceId", label:"内部数据源ID", minWidth:100},
				{prop:"storageMode", label:"存储形式 1：体内
2：体外", minWidth:100},
				{prop:"status", label:"01：维护中 02：已发布 03：已停用", minWidth:100},
				{prop:"createId", label:"创建人ID", minWidth:100},
				{prop:"createName", label:"创建人名称", minWidth:100},
				{prop:"createTime", label:"创建时间", minWidth:100},
				{prop:"updateId", label:"更新人ID", minWidth:100},
				{prop:"updateName", label:"更新人名称", minWidth:100},
				{prop:"updateTime", label:"更新时间", minWidth:100},
				{prop:"deleteFlag", label:"1：删除 0：正常", minWidth:100},
			],
			pageRequest: { pageNum: 1, pageSize: 8 },
			pageResult: {},

			operation: false, // true:新增, false:编辑
			editDialogVisible: false, // 新增编辑界面是否显示
			editLoading: false,
			dataFormRules: {
				label: [
					{ required: true, message: '请输入名称', trigger: 'blur' }
				]
			},
			// 新增编辑界面数据
			dataForm: {
				id: null,
				name: null,
				deptCode: null,
				deptName: null,
				timeScope: null,
				spaceScope: null,
				frequency: null,
				dataFormat: null,
				dataAccuracy: null,
				dataCount: null,
				dataSize: null,
				dataProvider: null,
				purposeExplanation: null,
				outerDatasourceId: null,
				innerDatasourceId: null,
				storageMode: null,
				status: null,
				createId: null,
				createName: null,
				createTime: null,
				updateId: null,
				updateName: null,
				updateTime: null,
				deleteFlag: null,
			}
		}
	},
	methods: {
		// 获取分页数据
		findPage: function (data) {
			if(data !== null) {
				this.pageRequest = data.pageRequest
			}
			this.pageRequest.columnFilters = {label: {name:'label', value:this.filters.label}}
			this.$api.resources.findPage(this.pageRequest).then((res) => {
				this.pageResult = res.data
			}).then(data!=null?data.callback:'')
		},
		// 批量删除
		handleDelete: function (data) {
			this.$api.resources.batchDelete(data.params).then(data!=null?data.callback:'')
		},
		// 显示新增界面
		handleAdd: function () {
			this.editDialogVisible = true
			this.operation = true
			this.dataForm = {
				id: null,
				name: null,
				deptCode: null,
				deptName: null,
				timeScope: null,
				spaceScope: null,
				frequency: null,
				dataFormat: null,
				dataAccuracy: null,
				dataCount: null,
				dataSize: null,
				dataProvider: null,
				purposeExplanation: null,
				outerDatasourceId: null,
				innerDatasourceId: null,
				storageMode: null,
				status: null,
				createId: null,
				createName: null,
				createTime: null,
				updateId: null,
				updateName: null,
				updateTime: null,
				deleteFlag: null,
			}
		},
		// 显示编辑界面
		handleEdit: function (params) {
			this.editDialogVisible = true
			this.operation = false
			this.dataForm = Object.assign({}, params.row)
		},
		// 编辑
		submitForm: function () {
			this.$refs.dataForm.validate((valid) => {
				if (valid) {
					this.$confirm('确认提交吗？', '提示', {}).then(() => {
						this.editLoading = true
						let params = Object.assign({}, this.dataForm)
						this.$api.resources.save(params).then((res) => {
							if(res.code == 200) {
								this.$message({ message: '操作成功', type: 'success' })
							} else {
								this.$message({message: '操作失败, ' + res.msg, type: 'error'})
							}
							this.editLoading = false
							this.$refs['dataForm'].resetFields()
							this.editDialogVisible = false
							this.findPage(null)
						})
					})
				}
			})
		},
		// 时间格式化
      	dateFormat: function (row, column, cellValue, index){
          	return format(row[column.property])
      	}
	},
	mounted() {
	}
}
</script>

<style scoped>

</style>
```
这里只是生成基本的CRUD代码，具体业务场景可以根据需要自定更改。

源码地址：[源码地址](https://github.com/pyygithub/pyy)

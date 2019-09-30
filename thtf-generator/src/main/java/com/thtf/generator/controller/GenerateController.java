package com.thtf.generator.controller;

import com.thtf.generator.common.response.Result;
import com.thtf.generator.common.response.ResultCode;
import com.thtf.generator.service.GenerateService;
import com.thtf.generator.vo.ConnParam;
import com.thtf.generator.vo.GenerateModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * ========================
 * 代码生成控制器
 * Author：pyy
 * Date：2019-9-25 17:07:15
 * Version: v1.0
 * ========================
 */
@RestController
@RequestMapping("/v1")
public class GenerateController {

	@Autowired
	private GenerateService generatorService;
	
	@PostMapping("/testConnection")
	public Result testConnection(@RequestBody ConnParam connParam) {
		boolean success = generatorService.testConnection(connParam);
		if(success) {
			return Result.SUCCESS();
		}
		return new Result(ResultCode.CONNECTION_ERROR);
	}

	@PostMapping("/getTables")
	public Result getTables(@RequestBody ConnParam connParam) {
		return Result.SUCCESS(generatorService.getTables(connParam));
	}
	
	@PostMapping("/getGenerateModel")
	public Result getGenerateModel(@RequestBody GenerateModel generateModel) {
		return Result.SUCCESS(generatorService.getGenerateModel(generateModel));
	}
	
	@PostMapping("/generateModels")
	public Result generateModels(@RequestBody GenerateModel generateModel) throws Exception {
		return Result.SUCCESS(generatorService.generateModels(generateModel));
	}
	
}

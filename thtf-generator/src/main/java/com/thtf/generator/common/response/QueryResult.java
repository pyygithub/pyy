package com.thtf.generator.common.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * ========================
 * 查询结果
 * Author：pyy
 * Date：2019/6/6
 * Time：10:10
 * Version: v1.0
 * ========================
 */
@Data
@ApiModel(value = "QueryResult",description = "分页结果")
public class QueryResult<T> {

    @ApiModelProperty("数据列表")
    private List<T> list;

    @ApiModelProperty("数据总数")
    private long total;

    public QueryResult(List<T> list, long total) {
        this.list = list;
        this.total = total;
    }
}

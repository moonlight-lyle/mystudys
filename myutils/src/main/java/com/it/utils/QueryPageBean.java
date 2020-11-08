package com.it.utils;
import lombok.Data;

import java.io.Serializable;
import java.util.Map;

/**
 * 自定义分页工具类
 * @author ：yp
 * @description : 封装查询条件
 * @version: 1.0 a=(当前页码-1)
 */
@Data
public class QueryPageBean implements Serializable{
    private Integer currentPage; // 页码
    private Integer pageSize;   //每页记录数
    private Map queryParams;    //查询条件


    private Integer offset; // 分页查询，开始记录下标

    /**
     * 获取分页起始记录位置
     * 根据分页页数，计算limit其实记录
     * @return
     */
    public Integer getOffset(){
        return (currentPage-1)*pageSize;
    }
}
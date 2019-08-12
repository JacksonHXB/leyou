package com.leyou.item.mapper;

import com.leyou.item.pojo.Category;

import tk.mybatis.mapper.additional.idlist.SelectByIdListMapper;
import tk.mybatis.mapper.common.Mapper;

/**
 * @Author JacksonDemo
 * @Time 2019年8月12日 下午9:42:07
 * @Description: TODO
 */
public interface CategoryMapper extends Mapper<Category>, SelectByIdListMapper<Category, Long>{

	
}


























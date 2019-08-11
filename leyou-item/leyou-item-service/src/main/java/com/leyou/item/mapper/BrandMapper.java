package com.leyou.item.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

import com.leyou.item.pojo.Brand;

import tk.mybatis.mapper.common.Mapper;



/**
 * @Author JacksonDemo
 * @Time 2019年8月11日 上午9:36:25
 * @Description: 品牌的同用Mapper
 */
public interface BrandMapper extends Mapper<Brand>{
	
	
	
	
	@Insert("insert into tb_category_brand (category_id, brand_id) values (#{cid}, #{bid})")
	void insertCategoryAndBrand(@Param("cid") Long cid, @Param("bid") Long bid);
	
}












































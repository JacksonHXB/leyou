package com.leyou.item.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.leyou.item.pojo.Brand;

import tk.mybatis.mapper.common.Mapper;



/**
 * @Author JacksonDemo
 * @Time 2019年8月11日 上午9:36:25
 * @Description: 品牌的同用Mapper
 */
public interface BrandMapper extends Mapper<Brand>{
	
	/**
	 * @param cid
	 * @param bid
	 * @Description 向中间表插入数据
	 */
	@Insert("insert into tb_category_brand (category_id, brand_id) values (#{cid}, #{bid})")
	void insertCategoryAndBrand(@Param("cid") Long cid, @Param("bid") Long bid);
	
	
	/**
	 * @param cid
	 * @return
	 * @Description 根据分类查询品牌列表
	 */
	@Select("select * from tb_brand a inner join tb_category_brand b on a.id = b.brand_id and b.category_id = #{cid}")
	List<Brand> selectBrandsByCid(Long cid);
	
}












































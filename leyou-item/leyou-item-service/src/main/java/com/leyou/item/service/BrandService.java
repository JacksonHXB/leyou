/**
 * 
 */
package com.leyou.item.service;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.leyou.common.pojo.PageResult;
import com.leyou.item.mapper.BrandMapper;
import com.leyou.item.pojo.Brand;

import tk.mybatis.mapper.entity.Example;



/**
 * @Author JacksonDemo
 * @Time 2019年8月11日 下午2:00:32
 * @Description: TODO
 */
@Service
public class BrandService {
	@Autowired
	private BrandMapper brandMapper;

	/**
	 * @param key
	 * @param page
	 * @param rows
	 * @param sortBy
	 * @param desc
	 * @return
	 * @Description 根据查询条件分页并排序查询品牌信息
	 */
	public PageResult<Brand> queryBrandsByPage(String key, Integer page, Integer rows, String sortBy, Boolean desc) {
		//初始化Example对象
		Example example = new Example(Brand.class);
		Example.Criteria criteria = example.createCriteria();
		
		//根据name模糊查询，或者根据首字母查询
		if(StringUtils.isNotBlank(key)) {
			criteria.andLike("name", "%" + key + "%").orEqualTo("letter", key);
		}
		
		//添加分页条件
		PageHelper.startPage(page, rows);
		
		//添加排序条件
		if(StringUtils.isNotBlank(sortBy)) {
			example.setOrderByClause(sortBy + " " + (desc ? "desc" : "asc"));
		}
		
		//查询数据集
		List<Brand> brands = brandMapper.selectByExample(example);
		
		//包装成PageInfo对象
		PageInfo<Brand> pageInfo = new PageInfo<>(brands);
		//包装成分页结果集
		return new PageResult<>(pageInfo.getTotal(), pageInfo.getList());
	}
	
	/**
	 * @param brand
	 * @param cids
	 * @Description 新增品牌
	 */
	@Transactional    //添加事务
	public void saveBrand(Brand brand, List<Long> cids) {
		//先新增brand
		brandMapper.insertSelective(brand);
		
		//新增中间表, 将品牌和分类建立关系
		cids.forEach(cid -> {
			brandMapper.insertCategoryAndBrand(cid, brand.getId());
		});
	}

	/**
	 * @param cid
	 * @return
	 * @Description 根据分类查询品牌列表
	 */
	public List<Brand> queryBrandsByCid(Long cid) {
		return brandMapper.selectBrandsByCid(cid);
	}
}























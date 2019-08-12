package com.leyou.item.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leyou.item.mapper.CategoryMapper;
import com.leyou.item.pojo.Category;

/**
 * @ClassName CategoryService
 * @Description TODO
 * @Author Administrator
 * @Date 2019/8/1 0001 下午 10:25
 * @Version 1.0
 **/
@Service
public class CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;
    
    /**
     * @param pid
     * @return
     * @Description 根据父节点查询子节点
     */
    public List<Category> queryCategoriesByPid(Long pid){
    	Category record = new Category();
    	record.setParentId(pid);
    	return this.categoryMapper.select(record);
    }
    
    
    
    /**
     * @param ids
     * @return
     * @Description 根据多个ID查询相应的分类名称
     */
    public List<String> queryNamesByIds(List<Long> ids){
    	List<Category> categories = categoryMapper.selectByIdList(ids);   //根据多个ID查询相应的集合
    	return categories.stream().map(category -> category.getName()).collect(Collectors.toList());
    }
    
}






























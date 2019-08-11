package com.leyou.item.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leyou.item.mapper.SpecGroupMapper;
import com.leyou.item.mapper.SpecParamMapper;
import com.leyou.item.pojo.SpecGroup;
import com.leyou.item.pojo.SpecParam;

/**
 * @Author JacksonDemo
 * @Time 2019年8月11日 下午9:56:02
 * @Description: 规格参数处理服务
 */
@Service
public class SpecificationService {
	
	
	@Autowired
	private SpecGroupMapper groupMapper;
	
	@Autowired
	private SpecParamMapper paramMapper;

	/**
	 * @param cid
	 * @return
	 * @Description 根据分类ID查询规格参数组
	 */
	public List<SpecGroup> queryGroupsByCid(Long cid) {
		SpecGroup record = new SpecGroup();
		record.setCid(cid);
		return groupMapper.select(record);
	}

	/**
	 * @param gid
	 * @return
	 * @Description 根据规格参数组ID获取规格参数列表
	 */
	public List<SpecParam> queryParams(Long gid) {
		SpecParam record = new SpecParam();
		record.setGroupId(gid);
		return paramMapper.select(record);
	}
}

































































































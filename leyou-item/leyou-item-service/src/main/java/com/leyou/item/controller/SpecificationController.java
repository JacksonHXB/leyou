package com.leyou.item.controller;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.leyou.item.pojo.SpecGroup;
import com.leyou.item.pojo.SpecParam;
import com.leyou.item.service.SpecificationService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(tags = "规格参数API")
@Controller
@RequestMapping("spec")
public class SpecificationController {
	@Autowired
	private SpecificationService specificationService;
	
	
	@ApiOperation("根据分类ID查询参数组")
	@GetMapping("groups/{cid}")
	public ResponseEntity<List<SpecGroup>> queryGroupsByCid(
		@ApiParam("分类ID") @PathVariable("cid")Long cid
	){
		List<SpecGroup> groups = specificationService.queryGroupsByCid(cid);
		if(CollectionUtils.isEmpty(groups)) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(groups);
	}
	
	
	@ApiOperation("根据条件获取规格参数列表")
	@GetMapping("params")
	public ResponseEntity<List<SpecParam>> queryParams(
		@ApiParam("规格参数组ID") @RequestParam(value="gid", required = false) Long gid,
		@ApiParam("商品分类ID") @RequestParam(value="cid", required = false) Long cid,
		@ApiParam("通用规格参数") @RequestParam(value = "generic", required = false) Boolean generic,
		@ApiParam("搜索字段") @RequestParam(value = "searching", required = false) Boolean searching
	){
		List<SpecParam> params = specificationService.queryParams(gid, cid, generic, searching);
		if(CollectionUtils.isEmpty(params)) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(params);
	}
	
}









































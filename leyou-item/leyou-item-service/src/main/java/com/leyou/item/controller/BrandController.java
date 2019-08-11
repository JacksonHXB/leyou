package com.leyou.item.controller;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.leyou.common.pojo.PageResult;
import com.leyou.item.pojo.Brand;
import com.leyou.item.service.BrandService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * @Author JacksonDemo
 * @Time 2019年8月11日 上午9:40:09
 * @Description: 品牌控制
 */
@Controller
@RequestMapping("brand")
@Api(value="品牌Controller")
public class BrandController {
	
	@Autowired
	private BrandService brandService;
	
	
	@ApiOperation("根据查询条件分页并排序查询品牌信息")
	@GetMapping("page")
	public ResponseEntity<PageResult<Brand>> queryBrandsByPage(
		@ApiParam("查询条件") @RequestParam(value = "key", required = false) String key,  
		@ApiParam("第几页") @RequestParam(value = "page", defaultValue = "1") Integer page,			
		@RequestParam(value = "rows", defaultValue = "5") Integer rows,			//单页的记录数
		@RequestParam(value = "sortBy", required = false) String sortBy,		//排序条件
		@RequestParam(value = "desc", required = false) Boolean desc			//排序规则，升序/降序
	){
		PageResult<Brand> result = brandService.queryBrandsByPage(key, page, rows, sortBy, desc);
		if(CollectionUtils.isEmpty(result.getItems())) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(result);
	}
	
	
	@ApiOperation("新增品牌")
	@PostMapping
	public ResponseEntity<Void> saveBrand(   //当传递的参数为JSON对象时，就只能用一个对象进行接收，前端采用qs将对象转为普通的参数进行传递，这里采用的是qs来进行处理接收
			@ApiParam("品牌的基础字段") Brand brand, 
			@ApiParam("分类ID集合") @RequestParam("cids") List<Long> cids
	){
		brandService.saveBrand(brand, cids);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
}



















































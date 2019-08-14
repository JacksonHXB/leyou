package com.leyou.item.controller;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.leyou.common.pojo.PageResult;
import com.leyou.item.bo.SpuBo;
import com.leyou.item.service.GoodsService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(tags = "商品服务")
@Controller
public class GoodsController {
	
	@Autowired
	private GoodsService goodsService;
	
	@ApiOperation("根据条件分页查询SPU")
	@GetMapping("spu/page")
	public ResponseEntity<PageResult<SpuBo>> querySpuByPage(
		@ApiParam("查询关键字")		@RequestParam(value="key", required = false) String key,
		@ApiParam("是否上架")		@RequestParam(value="saleable", defaultValue = "true") Boolean saleable,
		@ApiParam("分页")			@RequestParam(value="page", defaultValue = "1") Integer page,
		@ApiParam("单页记录数")		@RequestParam(value="rows", defaultValue = "5") Integer rows
			 
	){
		PageResult<SpuBo> result = goodsService.querySpuByPage(key, saleable, page, rows);
		if(result == null || CollectionUtils.isEmpty(result.getItems())) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(result);
	}
	
	
	@ApiOperation("保存商品")
	@PostMapping("goods")
	public ResponseEntity<Void> saveGoods(
		 @ApiParam("商品扩展实体") @RequestBody SpuBo spuBo
	){
		goodsService.saveGoods(spuBo);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
	
}







































































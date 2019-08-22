package com.leyou.item.controller;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.leyou.common.pojo.PageResult;
import com.leyou.item.bo.SpuBo;
import com.leyou.item.pojo.Sku;
import com.leyou.item.pojo.SpuDetail;
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
	
	
	@ApiOperation("更新商品")
	@GetMapping("goods")
	public ResponseEntity<Void> updateGoods(
		@ApiParam("spuBo对象") @RequestBody SpuBo spuBo
	){
		goodsService.updateGoods(spuBo);
		return ResponseEntity.noContent().build();
	}
	
	
	
	@ApiOperation("根据spuid查询spudetail")
	@GetMapping("spu/detail/{spuId}")
	public ResponseEntity<SpuDetail> querySpuDetailBySpuId(
		@ApiParam("SPUID") @PathVariable("spuId") Long spuId
	){
		
		SpuDetail spuDetail = goodsService.querySpuDetailBySpuId(spuId);
		if(spuDetail == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(spuDetail);
	}
	
	
	@ApiOperation("根据spuId查询sku集合")
	@GetMapping("sku/list")
	public ResponseEntity<List<Sku>> querySkusBySpuId(
		@ApiParam("spuId") @RequestParam("id") Long spuId
	){
		List<Sku> skus = goodsService.querySkusBySpuId(spuId);
		if(CollectionUtils.isEmpty(skus)) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(skus);
	}
	
}







































































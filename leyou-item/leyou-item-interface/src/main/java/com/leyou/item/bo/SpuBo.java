package com.leyou.item.bo;

import java.util.List;

import com.leyou.item.pojo.Sku;
import com.leyou.item.pojo.Spu;
import com.leyou.item.pojo.SpuDetail;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@ApiModel("商品的扩展对象,主要用于业务数据显示")
public class SpuBo extends Spu{
	@ApiModelProperty("分类名称")
	private String cname;
	
	@ApiModelProperty("品牌名称")
	private String bname;
	
	@ApiModelProperty("SPU详情")
	private SpuDetail spuDetail;
	
	
	@ApiModelProperty("SKU集合")
	private List<Sku> skus;
}


















































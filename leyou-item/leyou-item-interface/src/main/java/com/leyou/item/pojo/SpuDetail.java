package com.leyou.item.pojo;

import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("SpuDetail实体类")
@Table(name = "tb_spu_detail")
public class SpuDetail {
	@Id
	@ApiModelProperty("对应的SPU的ID")
	private Long spuId;
	
	@ApiModelProperty("商品描述")
	private String description;
	
	@ApiModelProperty("商品特殊规格的名称及可选值模板")
	private String specialSpec;
	
	@ApiModelProperty("商品的全局规格参数属性")
	private String genericSpec;
	
	@ApiModelProperty("包装清单")
	private String packingList;
	
	@ApiModelProperty("售后服务")
	private String afterService;
}































































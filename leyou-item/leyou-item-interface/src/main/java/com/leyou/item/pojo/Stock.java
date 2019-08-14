package com.leyou.item.pojo;

import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel("库存实体类")
@Data
@Table(name = "tb_stock")
public class Stock {
	
	@Id
	private Long skuId;
	
	@ApiModelProperty("秒杀可用库存")
	private Integer seckillStock;
	
	@ApiModelProperty("已秒杀数量")
	private Integer seckillTotal;
	
	@ApiModelProperty("正常库存")
	private Integer stock;
}





















































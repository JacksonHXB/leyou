package com.leyou.item.pojo;

import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel("SKU实体对象")
@Data
@Table(name = "tb_sku")
public class Sku {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Long spuId;
	private String title;
	private String images;
	private Long price;
	
	@ApiModelProperty("商品特殊规格兼职对")
	private String ownSpec;
	
	@ApiModelProperty("商品特殊规格的下标")
	private String indexes;
	
	@ApiModelProperty("是否有效，逻辑删除用")
	private Boolean enable;
	
	@ApiModelProperty("创建时间")
	private Date createTime;
	
	@ApiModelProperty("最后修改时间")
	private Date lastUpdateTime;
	
	@Transient //忽略该字段
	@ApiModelProperty("库存")
	private Integer stock;
}

























































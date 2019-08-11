package com.leyou.item.pojo;

import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel("Spu实体类")
@Data
@Table(name = "tb_spu")
public class Spu {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ApiModelProperty("品牌ID")
	private Long brandId;
	
	@ApiModelProperty("1级类目")
	private Long cid1;
	
	@ApiModelProperty("2级类目")
	private Long cid2;
	
	@ApiModelProperty("3级类目")
	private Long cid3;
	
	@ApiModelProperty("标题")
	private String title;
	
	@ApiModelProperty("子标题")
	private String subTitle;
	
	@ApiModelProperty("是否上架")
	private Boolean saleable;
	
	@ApiModelProperty("是否有效，逻辑删除用")
	private Boolean valid;
	
	@ApiModelProperty("创建时间")
	private Date createTime;
	
	@ApiModelProperty("最后修改时间")
	private Date lastUpdateTime;
}


































































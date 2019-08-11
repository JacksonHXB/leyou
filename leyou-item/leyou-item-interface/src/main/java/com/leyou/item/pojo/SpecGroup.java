package com.leyou.item.pojo;

import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Author JacksonDemo
 * @Time 2019年8月11日 下午9:34:30
 * @Description: 规格参数组
 */

@Data
@Table(name="tb_spec_group")
@ApiModel
public class SpecGroup {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ApiModelProperty("商品分类ID")
	private Long cid;
	
	@ApiModelProperty("规格组名称")
	private String name;
	
	@Transient
	private List<SpecParam> params;
}


























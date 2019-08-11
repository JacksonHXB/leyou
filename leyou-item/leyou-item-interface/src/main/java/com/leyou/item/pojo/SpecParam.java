package com.leyou.item.pojo;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

/**
 * @Author JacksonDemo
 * @Time 2019年8月11日 下午9:38:20
 * @Description: 规格参数实体类
 */
@Data
@Table(name = "tb_spec_param")
public class SpecParam {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Long cid;
	private Long groupId;
	private String name;
	@Column(name = "`numeric`")  //字段名与列名不一样时采用numeric，numeric在mysql中是关键字
	private Boolean numeric;
	private String unit;
	private Boolean generic;
	private Boolean searching;
	private String segments;
}




















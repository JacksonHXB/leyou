/**
 * 
 */
package com.leyou.item.pojo;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

/**
 * @Author JacksonDemo
 * @Time 2019年8月11日 上午9:25:03
 * @Description: 品牌实体对象
 */
@Data
@Table(name="tb_brand")
public class Brand {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String name; 			//品牌名称
	private String image;			//品牌图片
	private Character letter;		//品牌首字母
}



























/**
 * 
 */
package com.leyou.common.pojo;

import java.util.List;

import lombok.Data;

/**
 * @Author JacksonDemo
 * @Time 2019年8月11日 上午8:47:55
 * @Description: 接口返回数据的包装对象
 */
@Data
public class PageResult<T> {
	private Long total;   					//总数量
	private Integer totalPage;				//总页数
	private List<T> items;					//items
	
	public PageResult(Long total, List<T> items) {
		super();
		this.total = total;
		this.items = items;
	}
}

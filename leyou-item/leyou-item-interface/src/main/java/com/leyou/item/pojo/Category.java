package com.leyou.item.pojo;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @ClassName Category
 * @Description TODO
 * @Author Administrator
 * @Date 2019/7/31 0031 下午 11:33
 * @Version 1.0
 **/

@Data
@Table(name="tb_category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Long parentId;
    private Boolean isParent;    //注意isParent生成的getter和setter方法需要手动加上Is
    private Integer sort;
}
































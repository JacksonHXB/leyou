package com.leyou.item.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.leyou.item.pojo.Category;
import com.leyou.item.service.CategoryService;

/**
 * @ClassName CategoryController
 * @Description TODO
 * @Author Administrator
 * @Date 2019/8/1 0001 下午 10:28
 * @Version 1.0
 **/
@Controller
@RequestMapping("category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;


    //根据父节点的ID查询子节点
    @GetMapping("list")
    public ResponseEntity<List<Category>> queryCategoiesByPid(@RequestParam(value="pid", defaultValue = "0") Long pid){
		if(pid == null || pid < 0 ){
			//400 参数不合法
//		    return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
//		    return new ResponseEntity<List<Category>>(HttpStatus.BAD_REQUEST);
		    return ResponseEntity.badRequest().build();
		}
		List<Category> categories = this.categoryService.queryCategoriesByPid(pid);
		if(CollectionUtils.isEmpty(categories)){  
			// 404: 资源服务器未找到
//			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			return ResponseEntity.notFound().build();
		}
		//200：查询成功
		return ResponseEntity.ok(categories);

    }



}


























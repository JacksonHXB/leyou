package com.leyou.item.service;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.leyou.common.pojo.PageResult;
import com.leyou.item.bo.SpuBo;
import com.leyou.item.mapper.BrandMapper;
import com.leyou.item.mapper.SkuMapper;
import com.leyou.item.mapper.SpuDetailMapper;
import com.leyou.item.mapper.SpuMapper;
import com.leyou.item.mapper.StockMapper;
import com.leyou.item.pojo.Brand;
import com.leyou.item.pojo.Spu;
import com.leyou.item.pojo.SpuDetail;
import com.leyou.item.pojo.Stock;

import tk.mybatis.mapper.entity.Example;

@Service
public class GoodsService {
	@Autowired
	private SpuMapper spuMapper;
	
	@Autowired
	private SpuDetailMapper spuDetailMapper;
	
	@Autowired
	private BrandMapper brandMapper;
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private SkuMapper skuMapper;
	
	@Autowired
	private StockMapper stockMapper;

	/**
	 * @param key
	 * @param saleable
	 * @param page
	 * @param rows
	 * @Description 根据条件分页查询SPU
	 */
	public  PageResult<SpuBo> querySpuByPage(String key, Boolean saleable, Integer page, Integer rows) {
		Example example = new Example(Spu.class);
		Example.Criteria criteria = example.createCriteria();
		
		//添加查询条件
		if(StringUtils.isNotBlank(key)) {
			criteria.andLike("title", "%" + key + "%");
		}
		//添加saleable是否上下架过滤条件
		if(saleable != null) {
			criteria.andEqualTo("saleable", saleable);
		}
		//添加分页
		PageHelper.startPage(page, rows);
		
		//执行查询
		List<Spu> spuList = spuMapper.selectByExample(example);
		PageInfo<Spu> pageInfo = new PageInfo<>(spuList);
		
		//转为SpuBo集合
		List<SpuBo> spuBos = spuList.stream().map(spu -> {
			SpuBo spuBo = new SpuBo();
			BeanUtils.copyProperties(spu, spuBo);   //将spu中所有属性值copy到spuBo
			//查询品牌名称
			Brand brand = brandMapper.selectByPrimaryKey(spu.getBrandId());
			spuBo.setBname(brand.getName());   
			//查询分类名称
			List<String> names = categoryService.queryNamesByIds(Arrays.asList(spu.getCid1(), spu.getCid2(), spu.getCid3()));
			spuBo.setCname(StringUtils.join(names, "-"));		
			return spuBo;
		}).collect(Collectors.toList());
		
		//返回PageResult<SpuBo>
		return new PageResult<>(pageInfo.getTotal(), spuBos);
	}
	
	
	/**
	 * @param spuBo
	 * @Description 新增商品
	 */
	@Transactional
	public void saveGoods(SpuBo spuBo) {
		//新增SPU
		spuBo.setId(null);//防止客户端参数恶意注入
		spuBo.setSaleable(true);
		spuBo.setValid(true);
		spuBo.setCreateTime(new Date());
		spuBo.setLastUpdateTime(spuBo.getCreateTime());
		spuMapper.insertSelective(spuBo);
		
		//新增SpuDetail
		SpuDetail spuDetail = spuBo.getSpuDetail();
		spuDetail.setSpuId(spuBo.getId());
		spuDetailMapper.insertSelective(spuDetail);
		
		//新增SKU
		spuBo.getSkus().forEach(sku -> {
			//新增单条SKU
			sku.setId(null);
			sku.setSpuId(spuBo.getId());
			sku.setCreateTime(new Date());
			sku.setLastUpdateTime(sku.getCreateTime());
			skuMapper.insertSelective(sku);
			//新增stock
			Stock stock = new Stock();
			stock.setSkuId(sku.getId());
			stock.setStock(sku.getStock());
			stockMapper.insertSelective(stock);
		});		
	}
}







































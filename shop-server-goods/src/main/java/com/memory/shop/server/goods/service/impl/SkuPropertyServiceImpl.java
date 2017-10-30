package com.memory.shop.server.goods.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.memory.shop.api.goods.domain.SkuProperty;
import com.memory.shop.api.goods.domain.SkuPropertyValue;
import com.memory.shop.api.goods.service.ISkuPropertyService;
import com.memory.shop.server.goods.mapper.SkuPropertyMapper;
import com.memory.shop.server.goods.mapper.SkuPropertyValueMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


/**
 * Created by cyf on 2017/10/10.
 */

@Service
public class SkuPropertyServiceImpl implements ISkuPropertyService{

	@Autowired
	private SkuPropertyMapper skuPropertyMapper;

	@Autowired
	private SkuPropertyValueMapper skuPropertyValueMapper;

	@Override
	public List<SkuProperty> selectSkuByCatalogId(Long id) {
		return skuPropertyMapper.selectSkuByCatalogId(id);
	}

	@Override
	public SkuProperty selectSkuForEdit(Long id, Long catalogId) {
		SkuProperty property = new SkuProperty();
		if(id==-1){
			property.setId(-1L);
			property.setCatalogId(catalogId);
			return property;
		}else{
			SkuProperty skuProperty = skuPropertyMapper.selectByPrimaryKey(id);
			return skuProperty;
		}
	}

	@Override
	public void saveOrUpdate(SkuProperty skuProperty) {
		if(skuProperty.getId()==null){
			this.insert(skuProperty);
		}else{
			SkuProperty property = this.skuPropertyMapper.selectByPrimaryKey(skuProperty.getId());
			property.setName(skuProperty.getName());
			property.setType(skuProperty.getType());
			this.update(skuProperty);
		}
	}

	@Override
	public void insert(SkuProperty skuProperty) {
		skuProperty.setSequence(1);
		skuProperty.setType(2);
		this.skuPropertyMapper.insert(skuProperty);
	}

	@Override
	public void update(SkuProperty skuProperty) {
		skuProperty.setSequence(1);
		int effectRows=this.skuPropertyMapper.updateByPrimaryKey(skuProperty);
		if(effectRows<=0){
			throw new  RuntimeException("更新"+skuProperty.getId()+"失败");
		}
	}

	@Override
	public void delete(Long id) {
		SkuProperty skuProperty = this.skuPropertyMapper.selectByPrimaryKey(id);
		List<SkuPropertyValue> values = skuProperty.getValues();
		for (SkuPropertyValue value : values) {
			this.skuPropertyValueMapper.deleteByPrimaryKey(value.getId());
		}
		this.skuPropertyMapper.deleteByPrimaryKey(id);
	}

	@Override
	public SkuProperty selectByPrimaryId(Long id) {
		return this.skuPropertyMapper.selectByPrimaryKey(id);
	}


}

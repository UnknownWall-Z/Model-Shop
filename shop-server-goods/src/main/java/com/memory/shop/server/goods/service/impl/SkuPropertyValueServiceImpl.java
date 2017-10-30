package com.memory.shop.server.goods.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.memory.shop.api.goods.domain.SkuPropertyValue;
import com.memory.shop.api.goods.service.ISkuPropertyValueService;
import com.memory.shop.server.goods.mapper.SkuPropertyValueMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by cyf on 2017/10/10.
 */
@Service
public class SkuPropertyValueServiceImpl implements ISkuPropertyValueService {

	@Autowired
	private SkuPropertyValueMapper skuPropertyValueMapper;

	@Override
	public List<SkuPropertyValue> selectByPropertyId(Long id) {
		return skuPropertyValueMapper.selectBySkuPropertyId(id);
	}

	@Override
	public void updateSkuPropertyValue(Long id, String[] value) {
		if(id!=null){
			this.skuPropertyValueMapper.deleteByPropertyId(id);
			for (String s : value) {
				SkuPropertyValue propertyValue = new SkuPropertyValue();
				propertyValue.setSequence(2);
				propertyValue.setSkuPropertyId(id);
				propertyValue.setValue(s);
				this.skuPropertyValueMapper.insert(propertyValue);
			}
		}
	}
}

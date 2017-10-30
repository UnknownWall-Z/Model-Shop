package com.memory.shop.api.goods.service;

import com.memory.shop.api.goods.domain.SkuPropertyValue;

import java.util.List;

/**
 * Created by cyf on 2017/10/10.
 */
public interface ISkuPropertyValueService {
	List<SkuPropertyValue> selectByPropertyId(Long id);

	void updateSkuPropertyValue(Long id, String[] value);
}

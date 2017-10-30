package com.memory.shop.api.goods.service;

import com.memory.shop.api.goods.domain.SkuProperty;

import java.util.List;

/**
 * Created by cyf on 2017/10/10.
 */
public interface ISkuPropertyService {
	List<SkuProperty> selectSkuByCatalogId(Long id);

	SkuProperty selectSkuForEdit(Long id, Long catalogId);

	void saveOrUpdate(SkuProperty skuProperty);

	void insert(SkuProperty skuProperty);

	void update(SkuProperty skuProperty);

	void delete(Long id);

	SkuProperty selectByPrimaryId(Long id);
}

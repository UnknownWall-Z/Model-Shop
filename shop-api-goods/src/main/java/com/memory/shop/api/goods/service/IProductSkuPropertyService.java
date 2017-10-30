package com.memory.shop.api.goods.service;

import com.memory.shop.api.goods.domain.ProductSkuProperty;

import java.util.List;

/**
 * Created by cyf on 2017/10/10.
 */
public interface IProductSkuPropertyService {

	void insert(ProductSkuProperty productSkuProperty);

	List<String> selectValuesByProductSkuId(Long id);
}

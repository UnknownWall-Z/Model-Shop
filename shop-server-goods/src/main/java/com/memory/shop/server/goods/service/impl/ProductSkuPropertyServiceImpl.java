package com.memory.shop.server.goods.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.memory.shop.api.goods.domain.ProductSkuProperty;
import com.memory.shop.api.goods.service.IProductSkuPropertyService;
import com.memory.shop.server.goods.mapper.ProductSkuPropertyMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


/**
 * Created by cyf on 2017/10/10.
 */

@Service
public class ProductSkuPropertyServiceImpl implements IProductSkuPropertyService{


	@Autowired
	private ProductSkuPropertyMapper productSkuPropertyMapper;

	@Override
	public void insert(ProductSkuProperty productSkuProperty) {
		this.productSkuPropertyMapper.insert(productSkuProperty);
	}

	@Override
	public List<String> selectValuesByProductSkuId(Long id) {
		return productSkuPropertyMapper.selectValuesByProductSkuId(id);
	}
}

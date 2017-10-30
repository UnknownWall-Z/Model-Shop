package com.memory.shop.api.goods.service;

import com.memory.shop.api.goods.domain.ProductSku;
import com.memory.shop.api.goods.domain.SkuProperty;
import com.memory.shop.api.goods.vo.SkuGeneratorVo;
import com.memory.shop.api.goods.vo.SkuVO;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by cyf on 2017/10/10.
 */
public interface IProductSkuService {
	List<ProductSku> selectByProductId(Long id);

	List<Map<String, Object>> generateSku(SkuGeneratorVo skuGeneratorVo);

	List<SkuProperty> getSkuPropertieList(SkuGeneratorVo skuGeneratorVo);

	void saveSku(SkuVO skuVO);

	Set<String> getSkuPropertieList(List<ProductSku> productSkuList);

	ProductSku selectBySkuCode(String code);
}

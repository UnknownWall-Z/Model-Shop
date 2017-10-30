package com.memory.shop.server.goods.mapper;

import com.memory.shop.api.goods.domain.SkuPropertyValue;
import java.util.List;

public interface SkuPropertyValueMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SkuPropertyValue record);

    SkuPropertyValue selectByPrimaryKey(Long id);

    List<SkuPropertyValue> selectAll();

    int updateByPrimaryKey(SkuPropertyValue record);

    List<SkuPropertyValue> selectBySkuPropertyId(Long skuPropertyId);

	void deleteByPropertyId(Long id);
}
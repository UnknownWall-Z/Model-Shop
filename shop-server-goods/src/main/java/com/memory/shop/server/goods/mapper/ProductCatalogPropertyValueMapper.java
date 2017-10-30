package com.memory.shop.server.goods.mapper;

import com.memory.shop.api.goods.domain.ProductCatalogPropertyValue;
import java.util.List;

public interface ProductCatalogPropertyValueMapper {

    int insert(ProductCatalogPropertyValue record);

    int deleteByProductId(Long productId);

    List<ProductCatalogPropertyValue> selectAll();

    List<ProductCatalogPropertyValue> selectByProductId(Long id);

    int updateByPrimaryKey(ProductCatalogPropertyValue record);

}
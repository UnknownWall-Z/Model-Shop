package com.memory.shop.api.goods.service;

import com.memory.shop.api.goods.domain.ProductCatalogPropertyValue;

import java.util.List;

/**
 * Created by Administrator on 2017/10/10 0010.
 */

public interface IProductCatalogPropertyValueService {
    void insert(ProductCatalogPropertyValue productPropertyValue);

    void update(ProductCatalogPropertyValue productPropertyValue);

    ProductCatalogPropertyValue selectByKey(Long id);

    List<ProductCatalogPropertyValue> selectByProductId(Long id);

}

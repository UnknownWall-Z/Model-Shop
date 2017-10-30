package com.memory.shop.server.goods.mapper;

import com.memory.shop.api.goods.domain.ProductDesc;

public interface ProductDescMapper {

    int insert(ProductDesc record);

    ProductDesc selectByPrimaryKey(Long id);

    int updateByPrimaryKey(ProductDesc record);

    int updateByProductId(ProductDesc productDesc);

    ProductDesc selectByProductId(Long id);

}
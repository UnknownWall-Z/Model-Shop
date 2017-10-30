package com.memory.shop.server.goods.mapper;

import com.memory.shop.api.goods.domain.ProductSkuProperty;
import java.util.List;

public interface ProductSkuPropertyMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ProductSkuProperty record);

    ProductSkuProperty selectByPrimaryKey(Long id);

    List<ProductSkuProperty> selectAll();

    int updateByPrimaryKey(ProductSkuProperty record);

    List<ProductSkuProperty> selectByProductSkuId(Long productSkuId);


    List<String> selectValuesByProductSkuId(Long id);
}
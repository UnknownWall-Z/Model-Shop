package com.memory.shop.server.goods.mapper;

import com.memory.shop.api.goods.domain.ProductImage;

import java.util.List;

public interface ProductImageMapper {

    int insert(ProductImage record);

    int deleteByProductId(Long id);

    List<ProductImage> selectById(Long id);

    List<ProductImage> selectByProductId(Long id);

    int updateByPrimaryKey(ProductImage record);
}
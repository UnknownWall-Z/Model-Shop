package com.memory.shop.api.goods.service;

import com.memory.shop.api.goods.domain.ProductImage;

import java.util.List;

/**
 * Created by Administrator on 2017/10/10 0010.
 */
public interface IProductImageService {
    void insert(ProductImage productImage);

    void update(ProductImage productImage);

    ProductImage selectByKey(Long id);

    List<ProductImage> selectByProductId(Long id);

}

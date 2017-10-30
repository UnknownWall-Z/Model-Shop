package com.memory.shop.api.goods.service;

import com.memory.shop.api.goods.domain.ProductDesc;

/**
 * Created by Administrator on 2017/10/10 0010.
 */
public interface IProductDescServcie {
    void insert(ProductDesc productDesc);

    void update(ProductDesc productDesc);

    ProductDesc selectByKey(Long id);

    ProductDesc selectByProductId(Long id);
}

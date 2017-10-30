package com.memory.shop.api.goods.service;

import com.memory.shop.api.goods.domain.Product;
import com.memory.shop.api.goods.domain.ProductInfo;
import com.memory.shop.api.goods.query.PageResult;
import com.memory.shop.api.goods.query.ProductQueryObject;

/**
 * Created by zmh on 2017/9/28.
 */
public interface IProductService {

    void insert(ProductInfo productInfo);

    void insertProduct(Product product);

    void update(Product product);

    Product selectById(Long id);

    PageResult queryPage(ProductQueryObject queryObject);

    void update(ProductInfo productInfo);
}

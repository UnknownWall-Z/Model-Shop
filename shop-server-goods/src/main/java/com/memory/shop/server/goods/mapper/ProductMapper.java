package com.memory.shop.server.goods.mapper;


import com.memory.shop.api.goods.domain.Product;
import com.memory.shop.api.goods.query.ProductQueryObject;

import java.util.List;

public interface ProductMapper {

    int insert(Product record);

    Product selectByPrimaryKey(Long id);

    int updateByPrimaryKey(Product record);

    int queryForCount(ProductQueryObject queryObject);

    List<Product> queryForList(ProductQueryObject queryObject);

}
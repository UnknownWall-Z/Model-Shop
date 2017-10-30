package com.memory.shop.server.goods.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.memory.shop.api.goods.domain.ProductCatalogPropertyValue;
import com.memory.shop.api.goods.service.IProductCatalogPropertyValueService;
import com.memory.shop.server.goods.mapper.ProductCatalogPropertyValueMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by Administrator on 2017/10/10 0010.
 */
@Service
public class ProductCatalogPropertyValueServiceImpl implements IProductCatalogPropertyValueService {
    @Autowired
    private ProductCatalogPropertyValueMapper productCatalogPropertyValueMapper;

    @Override
    public void insert(ProductCatalogPropertyValue productPropertyValue) {

    }

    @Override
    public void update(ProductCatalogPropertyValue productPropertyValue) {

    }

    @Override
    public ProductCatalogPropertyValue selectByKey(Long id) {
        return null;
    }

    @Override
    public List<ProductCatalogPropertyValue> selectByProductId(Long id) {
        return productCatalogPropertyValueMapper.selectByProductId(id);
    }

}

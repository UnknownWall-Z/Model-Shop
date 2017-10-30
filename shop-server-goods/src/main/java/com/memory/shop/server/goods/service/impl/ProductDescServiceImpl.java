package com.memory.shop.server.goods.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.memory.shop.api.goods.domain.ProductDesc;
import com.memory.shop.api.goods.service.IProductDescServcie;
import com.memory.shop.server.goods.mapper.ProductDescMapper;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Administrator on 2017/10/10 0010.
 */
@Service
public class ProductDescServiceImpl implements IProductDescServcie {

    @Autowired
    private ProductDescMapper productDescMapper;

    @Override
    public void insert(ProductDesc productDesc) {

    }

    @Override
    public void update(ProductDesc productDesc) {

    }

    @Override
    public ProductDesc selectByKey(Long id) {
        return null;
    }

    @Override
    public ProductDesc selectByProductId(Long id) {
        return productDescMapper.selectByProductId(id);
    }
}

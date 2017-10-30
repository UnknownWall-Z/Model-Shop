package com.memory.shop.server.goods.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.memory.shop.api.goods.domain.ProductImage;
import com.memory.shop.api.goods.service.IProductImageService;
import com.memory.shop.server.goods.mapper.ProductImageMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by Administrator on 2017/10/10 0010.
 */
@Service
public class ProductImageServiceImpl implements IProductImageService {

    @Autowired
    private ProductImageMapper productImageMapper;

    @Override
    public void insert(ProductImage productImage) {

    }

    @Override
    public void update(ProductImage productImage) {

    }

    @Override
    public ProductImage selectByKey(Long id) {
        return null;
    }

    @Override
    public List<ProductImage> selectByProductId(Long id) {
        return productImageMapper.selectByProductId(id);
    }
}

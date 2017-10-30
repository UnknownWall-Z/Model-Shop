package com.memory.shop.api.goods.service;

import com.memory.shop.api.goods.domain.Brand;
import com.memory.shop.api.goods.query.BrandQueryObject;
import com.memory.shop.api.goods.query.PageResult;

import java.util.List;

/**
 * Created by zmh on 2017/10/9.
 */
public interface IBrandService {
    void update(Brand record);

    Brand selectByPrimaryKey(Long id);

    PageResult query(BrandQueryObject qo);

    void saveOrUpdate(Brand brand);

    List<Brand> selectAll();
}

package com.memory.shop.server.goods.mapper;

import com.memory.shop.api.goods.domain.Brand;
import com.memory.shop.api.goods.query.BrandQueryObject;

import java.util.List;

public interface BrandMapper {

    int insert(Brand record);

    Brand selectByPrimaryKey(Long id);

    int updateByPrimaryKey(Brand record);

    int queryForCount(BrandQueryObject qo);

    List<Brand> queryForList(BrandQueryObject qo);

    List<Brand> selectAll();
}
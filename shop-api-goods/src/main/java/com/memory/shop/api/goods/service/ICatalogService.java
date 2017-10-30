package com.memory.shop.api.goods.service;

import com.memory.shop.api.goods.domain.Catalog;

import java.util.List;

/**
 * Created by Administrator on 2017/10/9 0009.
 */
public interface ICatalogService {

    int insert(Catalog record);

    Catalog selectByPrimaryKey(Long id);

    List<Catalog> selectAll();

    int updateByPrimaryKey(Catalog record);

    void delete(Long id);


    /**
     * 商品乐观锁
     * @param catalog
     */
    void  update(Catalog catalog);

    /**
     * 获取子商品 ,  根据父商品id 获取
     * @param id
     * @return
     */
    List<Catalog> getChineCatalogById(Long id);

    List<Catalog> getParents();

    int getMaxLevel();
}

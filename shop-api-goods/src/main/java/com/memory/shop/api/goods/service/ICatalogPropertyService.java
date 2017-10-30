package com.memory.shop.api.goods.service;

/**
 * Created by wall on 2017/10/9.
 */

import com.memory.shop.api.goods.domain.CatalogProperty;

import java.util.List;

/***
 *  商品属性
 *  ----------------------+>>>>
 */
public interface ICatalogPropertyService {

    CatalogProperty get(long id);

    List<CatalogProperty> list();

    List<CatalogProperty> getPropertyByCatalogId(Long catalogId);

    void add(CatalogProperty catalogProperty);

    void update(CatalogProperty catalogProperty);

    void delete(long catalogPropertyId);

    void deleteByCatalogId(Long catalogId);

    List<Long> getIdsByCatalogId(Long catalogId);

}

package com.memory.shop.api.goods.service;

import com.memory.shop.api.goods.domain.CatalogPropertyValue;

import java.util.List;

/**
 * Created by wall on 2017/10/9.
 */
public interface ICatalogPropertyValueService {

    void delete(long valueId);

    List<CatalogPropertyValue> catalogPropertyValueListByCatalogId(long catalogPropertyId);

    void save(String value, long catalogPropertyId, int sequence);

    void deleteByPropertyId(Long id);

    void deleteByCatalogPropertyIds(List<Long> ids);
}

package com.memory.shop.server.goods.mapper;

import com.memory.shop.api.goods.domain.CatalogPropertyValue;
import java.util.List;

public interface CatalogPropertyValueMapper {
    int deleteByPrimaryKey(Long id);

    int insert(CatalogPropertyValue record);

    CatalogPropertyValue selectByPrimaryKey(Long id);

    List<CatalogPropertyValue> selectAll();

    int updateByPrimaryKey(CatalogPropertyValue record);

    List<CatalogPropertyValue> catalogPropertyValueListByCatalogId(long catalogPropertyId);

    void deleteByPropertyId(Long id);

    void deleteByCatalogPropertyIds(List<Long> ids);
}
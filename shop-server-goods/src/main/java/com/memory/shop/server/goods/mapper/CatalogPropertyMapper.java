package com.memory.shop.server.goods.mapper;

import com.memory.shop.api.goods.domain.CatalogProperty;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CatalogPropertyMapper {

    int deleteByPrimaryKey(Long id);

    int insert(CatalogProperty record);

    CatalogProperty selectByPrimaryKey(Long id);

    List<CatalogProperty> selectAll();

    int updateByPrimaryKey(CatalogProperty record);

    List<CatalogProperty> getPropertyByCatalogId(Long catalogId);

    void deleteByTwoId(@Param("catalogId") Long catalogId, @Param("id") Long id);

    CatalogProperty getByTwoId(@Param("catalogId") Long catalogId, @Param("id") Long id);

    void deleteByCatalogId(Long catalogId);

    List<Long> getIdsByCatalogId(Long catalogId);
}
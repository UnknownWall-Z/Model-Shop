package com.memory.shop.server.goods.mapper;

import com.memory.shop.api.goods.domain.Catalog;
import java.util.List;

public interface CatalogMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Catalog record);

    Catalog selectByPrimaryKey(Long id);

    List<Catalog> selectAll();

    int updateByPrimaryKey(Catalog record);

    /**
     * 查询子商品,根据父商品id 查
     * @param parentId
     * @return
     */
    List<Catalog> getChineCatalogById(Long parentId);

    List<Catalog> getParents();

    int getMaxLevel();
}
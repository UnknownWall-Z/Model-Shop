package com.memory.shop.server.goods.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.memory.shop.api.goods.domain.CatalogProperty;
import com.memory.shop.api.goods.service.ICatalogPropertyService;
import com.memory.shop.server.goods.mapper.CatalogPropertyMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by wall on 2017/10/9.
 */
@Service
public class CatalogPropertyServiceImpl implements ICatalogPropertyService{

    @Autowired
    private CatalogPropertyMapper catalogPropertyMapper;

    @Override
    public CatalogProperty get(long id) {
        return catalogPropertyMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<CatalogProperty> list() {
        return catalogPropertyMapper.selectAll();
    }

    @Override
    public List<CatalogProperty> getPropertyByCatalogId(Long catalogId) {
        return catalogPropertyMapper.getPropertyByCatalogId(catalogId);
    }

    @Override
    public void add(CatalogProperty catalogProperty) {
        catalogPropertyMapper.insert(catalogProperty);
    }

    @Override
    public void update(CatalogProperty catalogProperty) {
        catalogPropertyMapper.updateByPrimaryKey(catalogProperty);
    }

    @Override
    public void delete(long catalogPropertyId) {
        catalogPropertyMapper.deleteByPrimaryKey(catalogPropertyId);
    }

    @Override
    public void deleteByCatalogId(Long catalogId) {
        catalogPropertyMapper.deleteByCatalogId(catalogId);
    }

    @Override
    public List<Long> getIdsByCatalogId(Long catalogId) {
        return catalogPropertyMapper.getIdsByCatalogId(catalogId);
    }

}

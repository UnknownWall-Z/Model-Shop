package com.memory.shop.server.goods.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.memory.shop.api.goods.domain.CatalogProperty;
import com.memory.shop.api.goods.domain.CatalogPropertyValue;
import com.memory.shop.api.goods.service.ICatalogPropertyValueService;
import com.memory.shop.server.goods.mapper.CatalogPropertyValueMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by wall on 2017/10/9.
 */
@Service
public class CatalogPropertyValueServiceValue implements ICatalogPropertyValueService{

    @Autowired
    private CatalogPropertyValueMapper catalogPropertyValueMapper;

    @Override
    public void delete(long valueId) {
        catalogPropertyValueMapper.deleteByPrimaryKey(valueId);
    }

    @Override
    public List<CatalogPropertyValue> catalogPropertyValueListByCatalogId(long catalogPropertyId) {
        return catalogPropertyValueMapper.catalogPropertyValueListByCatalogId(catalogPropertyId);
    }

    @Override
    public void save(String value, long catalogPropertyId, int sequence) {
        CatalogProperty catalogProperty = new CatalogProperty();
        catalogProperty.setId(catalogPropertyId);
        CatalogPropertyValue catalogPropertyValue = new CatalogPropertyValue();
        catalogPropertyValue.setValue(value);
        catalogPropertyValue.setSequence(sequence);
        catalogPropertyValue.setCatalogProperty(catalogProperty);
        catalogPropertyValueMapper.insert(catalogPropertyValue);
    }

    @Override
    public void deleteByPropertyId(Long id) {
        catalogPropertyValueMapper.deleteByPropertyId(id);
    }

    @Override
    public void deleteByCatalogPropertyIds(List<Long> ids) {
        if(ids.size() > 0){
            catalogPropertyValueMapper.deleteByCatalogPropertyIds(ids);
        }
    }

}

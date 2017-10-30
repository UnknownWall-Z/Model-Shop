package com.memory.shop.server.goods.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.memory.shop.api.goods.domain.Catalog;
import com.memory.shop.api.goods.service.ICatalogService;
import com.memory.shop.server.goods.mapper.CatalogMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.List;

/**
 * Created by Administrator on 2017/10/9 0009.
 */
@Service
@EnableTransactionManagement
public class CatalogServiceImpl implements ICatalogService{

    @Autowired
    private CatalogMapper catalogMapper;

    @Override
    public int insert(Catalog record) {
        return catalogMapper.insert(record);
    }

    @Override
    public Catalog selectByPrimaryKey(Long id) {
        return catalogMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Catalog> selectAll() {
        return catalogMapper.selectAll();
    }

    @Override
    public int updateByPrimaryKey(Catalog record) {
        return catalogMapper.updateByPrimaryKey(record);
    }

    @Override
    public void delete(Long id) {
        catalogMapper.deleteByPrimaryKey(id);
    }

    /**
     * 乐观锁监控
     * @param catalog
     */
    @Override
    public void update(Catalog catalog) {
        int key = catalogMapper.updateByPrimaryKey(catalog);
        if (key<=0){
         throw  new RuntimeException("Catalog :乐观锁失败"+catalog.getId());
        }
    }

    /**
     * 获取子商品, 根据父商品的id
     * @param parentId
     * @return
     */
    @Override
    public List<Catalog> getChineCatalogById(Long parentId) {
        List<Catalog> list= catalogMapper.getChineCatalogById(parentId);
        return list ;
    }

    @Override
    public List<Catalog> getParents() {
        return catalogMapper.getParents();
    }

    @Override
    public int getMaxLevel() {
        return catalogMapper.getMaxLevel();
    }
}

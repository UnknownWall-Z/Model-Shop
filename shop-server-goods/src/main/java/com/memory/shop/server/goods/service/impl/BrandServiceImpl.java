package com.memory.shop.server.goods.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.memory.shop.api.goods.domain.Brand;
import com.memory.shop.api.goods.query.BrandQueryObject;
import com.memory.shop.api.goods.query.PageResult;
import com.memory.shop.api.goods.service.IBrandService;
import com.memory.shop.server.goods.mapper.BrandMapper;
import com.memory.shop.server.goods.message.SendOrder;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

/**
 * Created by zmh on 2017/10/9.
 */
@Service
public class BrandServiceImpl implements IBrandService {

    @Autowired
    private BrandMapper brandMapper;

    @Autowired
    private SendOrder sendOrder;

    @Override
    public void update(Brand record) {
        int i = brandMapper.updateByPrimaryKey(record);
        if(i <= 0){
            throw new RuntimeException("乐观锁失败,Brand:" + record.getId());
        }
    }

    @Override
    public Brand selectByPrimaryKey(Long id) {
        return brandMapper.selectByPrimaryKey(id);
    }

    @Override
    public PageResult query(BrandQueryObject qo) {

        sendOrder.sendMessageQueue(11111111111L);
        sendOrder.sendMessageTopic(22222222222L);

        int count = brandMapper.queryForCount(qo);
        if(count > 0){
            List<Brand> list = brandMapper.queryForList(qo);
            return new PageResult(list,count,qo.getCurrentPage(),qo.getPageSize());
        }
        return PageResult.empty(qo.getPageSize());
    }

    @Override
    public void saveOrUpdate(Brand brand) {
        if(brand.getId() != null){
            brand.setLastModifiedDate(new Date());
            Brand brand1 = brandMapper.selectByPrimaryKey(brand.getId());
            brand.setVersion(brand.getVersion());
            this.update(brand);
        }else{
            brand.setCreatedDate(new Date());
            brandMapper.insert(brand);
        }
    }

    @Override
    public List<Brand> selectAll() {
        return brandMapper.selectAll();
    }
}

package com.memory.ice.server.goods.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.memory.ice.api.domain.IceBrand;
import com.memory.ice.api.query.IceBrandQueryObject;
import com.memory.ice.api.query.PageResult;
import com.memory.ice.api.service.IceBrandService;
import com.memory.ice.server.goods.mapper.IceBrandMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
//@EnableTransactionManagement
public class IceBrandImpl implements IceBrandService,ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private IceBrandMapper iceBrandMapper;

    @Override
    public void save(IceBrand iceBrand) {
        iceBrandMapper.insert(iceBrand);
    }

    @Override
//    @Transactional
    public void update(IceBrand iceBrand) {
        int judge = iceBrandMapper.updateByPrimaryKey(iceBrand);
        if(judge <=0 ){
            new RuntimeException("乐观锁失败:"+iceBrand.getId());
        }
    }
    @Override
    public PageResult query(IceBrandQueryObject qo) {
        int count = iceBrandMapper.count(qo);
        if(count>0){
            List<IceBrand> iceBrands = iceBrandMapper.ListData(qo);
            return new PageResult(iceBrands,count,qo.getCurrentPage(),qo.getPageSize());
        }
        return PageResult.empty(count);
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        System.out.println(event+"---------->");
        PageResult query = query(new IceBrandQueryObject());
        List listData = query.getListData();
        for (Object listDatum : listData) {
            System.out.println(listData);
        }
    }
    @Override
    public String test(){
        System.out.println("<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>");
        return "<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>";
    }

}

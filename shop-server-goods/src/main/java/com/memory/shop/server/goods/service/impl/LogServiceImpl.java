package com.memory.shop.server.goods.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.memory.shop.api.goods.domain.Log;
import com.memory.shop.api.goods.query.LogQueryObject;
import com.memory.shop.api.goods.query.PageResult;
import com.memory.shop.api.goods.service.IlogService;
import com.memory.shop.server.goods.mapper.LogMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by wall on 2017/10/13.
 */
@Service
public class LogServiceImpl implements IlogService{

    @Autowired
    private LogMapper logMapper;

    @Override
    public void save(Log log) {
        logMapper.insert(log);
    }

    @Override
    public PageResult query(LogQueryObject qo) {

        int count = logMapper.count(qo);
        if(count>0){
            List<Log> logs = logMapper.listData(qo);
            return new PageResult(logs,count,qo.getCurrentPage(),qo.getPageSize());
        }
        return PageResult.empty(count);
    }

    @Override
    public void removeAll() {
        logMapper.delete();
    }

    @Override
    public int count() {
        return logMapper.total();
    }
}

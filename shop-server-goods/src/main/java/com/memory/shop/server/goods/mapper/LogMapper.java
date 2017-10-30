package com.memory.shop.server.goods.mapper;

import com.memory.shop.api.goods.domain.Log;
import com.memory.shop.api.goods.query.LogQueryObject;

import java.util.List;

public interface LogMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Log record);

    Log selectByPrimaryKey(Long id);

    int count(LogQueryObject qo);

    List<Log> listData(LogQueryObject qo);

    void delete();

    int total();
}
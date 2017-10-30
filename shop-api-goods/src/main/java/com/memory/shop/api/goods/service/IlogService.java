package com.memory.shop.api.goods.service;

import com.memory.shop.api.goods.domain.Log;
import com.memory.shop.api.goods.query.LogQueryObject;
import com.memory.shop.api.goods.query.PageResult;

/**
 * Created by wall on 2017/10/13.
 */

public interface IlogService {

    void save(Log log);

    PageResult query(LogQueryObject qo);

    void removeAll();

    int count();
}

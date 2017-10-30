package com.memory.shop.api.goods.service;

import com.memory.shop.api.goods.domain.Log;

/**
 * Created by wall on 2017/10/17.
 */
public interface IZSendService {

    void printSend(Log log);

    void empty();

    int getLogCount();
}

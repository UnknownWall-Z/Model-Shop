package com.memory.shop.server.order.mapper;


import com.memory.shop.api.order.domain.OrderInfo;
import com.memory.shop.api.order.query.OrderInfoQueryObject;

import java.util.List;

public interface OrderInfoMapper {

    int insert(OrderInfo record);

    OrderInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKey(OrderInfo record);

    int getTotalCount(OrderInfoQueryObject qo);

    List<OrderInfo> getListdata(OrderInfoQueryObject qo);

    Long getUserId(Long id);
}
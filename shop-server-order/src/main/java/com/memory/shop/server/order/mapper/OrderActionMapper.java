package com.memory.shop.server.order.mapper;

import com.memory.shop.api.order.domain.OrderAction;

import java.util.List;

public interface OrderActionMapper {

    int insert(OrderAction record);

    OrderAction selectByPrimaryKey(Long id);

    int updateByPrimaryKey(OrderAction record);

    List<OrderAction> queryByOrderId(Long orderId);
}
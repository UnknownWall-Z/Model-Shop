package com.memory.shop.api.order.service;

import com.memory.shop.api.order.domain.OrderAction;

import java.util.List;

/**
 * Created by 76585 on 2017/10/10.
 */
public interface IOrderActionService {
    List<OrderAction> queryByOrderId(Long id);
}

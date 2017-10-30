//package com.xmg.shop.server.order.service.impl;
//
//import com.alibaba.dubbo.config.annotation.Service;
//import com.memory.shop.api.order.domain.OrderAction;
//import com.memory.shop.api.order.service.IOrderActionService;
//import com.memory.shop.server.order.mapper.OrderActionMapper;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import java.util.List;
//
//@Service
//public class OrderActionServiceImpl implements IOrderActionService{
//
//    @Autowired
//    private OrderActionMapper actionMapper;
//
//    @Override
//    public List<OrderAction> queryByOrderId(Long id) {
//        return this.actionMapper.queryByOrderId(id);
//    }
//}

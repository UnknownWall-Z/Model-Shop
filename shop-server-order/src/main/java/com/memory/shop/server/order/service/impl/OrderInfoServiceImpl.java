//package com.xmg.shop.server.order.service.impl;
//
//
//import com.alibaba.dubbo.config.annotation.Service;
//import com.memory.shop.api.order.domain.OrderAction;
//import com.memory.shop.api.order.domain.OrderInfo;
//import com.memory.shop.api.order.query.OrderInfoQueryObject;
//import com.memory.shop.api.order.service.IOrderInfoService;
//import com.memory.shop.server.order.mapper.OrderActionMapper;
//import org.springframework.beans.factory.annotation.Autowired;
//import com.memory.shop.server.order.mapper.OrderInfoMapper;
//import com.memory.shop.api.order.page.PageResult;
//
//
//
//import java.util.Date;
//import java.util.List;
//
///**
// * Created by 76585 on 2017/10/10.
// */
//@Service
//public class OrderInfoServiceImpl implements IOrderInfoService {
//
//    @Autowired
//    private OrderInfoMapper orderInfoMapper;
//
//    @Autowired
//    private OrderActionMapper orderActionMapper;
//
//    @Override
//    public void update(OrderInfo orderInfo) {
//        int ret = this.orderInfoMapper.updateByPrimaryKey(orderInfo);
//        if (ret <= 0){
//            throw new RuntimeException("乐观锁失败:orderInfo" + orderInfo.getId());
//        }
//    }
//
//    @Override
//    public PageResult pageQuery(OrderInfoQueryObject qo) {
//        int totalCount = this.orderInfoMapper.getTotalCount(qo);
//        if (totalCount == 0){
//            return PageResult.empty(qo.getPageSize());
//        }
//        List<OrderInfo> listdata = this.orderInfoMapper.getListdata(qo);
//        return new PageResult(listdata,totalCount,qo.getCurrentPage(),qo.getPageSize());
//    }
//
//    @Override
//    public OrderInfo get(Long id) {
//        return orderInfoMapper.selectByPrimaryKey(id);
//    }
//
//    @Override
//    public Long getUserId(Long id) {
//        return orderInfoMapper.getUserId(id);
//    }
//
//    /*处理确认订单操作*/
//    @Override
//    public void audit(Long id, int state, String remark) {
//        //根据订单的id 查询对应的订单 并修改订单的属性状态
//        OrderInfo orderInfo = orderInfoMapper.selectByPrimaryKey(id);
//        orderInfo.setOrderStatus(OrderInfo.ORDERSTATUS_OK);
//        //更新orderinfo 并新增一条orderaction
//        this.update(orderInfo);
//        OrderAction orderAction = new OrderAction();
//        orderAction.setOrder(orderInfo);
//        orderAction.setActionTime(new Date());
//        orderAction.setActionNote(remark);
//        orderAction.setActionPlace("紫荆之巅");
//        orderAction.setOrderStatus(orderInfo.getOrderStatus());
//        orderAction.setPayStatus(orderInfo.getPayStatus());
//        orderAction.setShippingStatus(orderInfo.getShippingStatus());
//        orderAction.setActionUser(orderInfo.getUser());
//        orderActionMapper.insert(orderAction);
//    }
//
//    //发货操作
//    @Override
//    public void auditFH(Long id, int state, String remark) {
//        //判断是否是确认订单状态
//        OrderInfo orderInfo = orderInfoMapper.selectByPrimaryKey(id);
//        if (orderInfo.getOrderStatus()==1){
//            //修改发货状态
//            orderInfo.setShippingStatus(OrderInfo.SHIPPINGSTATUS_SEND);
//            orderInfo.setSendDate(new Date());
//            this.update(orderInfo);
//            //添加一条orderaction
//            OrderAction action = new OrderAction();
//            action.setOrderStatus(orderInfo.getOrderStatus());
//            action.setActionUser(orderInfo.getUser());
//            action.setShippingStatus(OrderInfo.SHIPPINGSTATUS_SEND);
//            action.setPayStatus(orderInfo.getPayStatus());
//            action.setActionPlace("上海");
//            action.setActionNote(remark);
//            action.setActionTime(new Date());
//            action.setOrder(orderInfo);
//            orderActionMapper.insert(action);
//        }else {
//            throw new RuntimeException("操作失败！");
//        }
//
//    }
//    /*完成订单*/
//    @Override
//    public void auditWCDD(Long id, int state, String remark) {
//        //判断是否是确认订单状态
//        OrderInfo orderInfo = orderInfoMapper.selectByPrimaryKey(id);
//        //修改支付状态
//        orderInfo.setPayStatus(OrderInfo.ORDERINFO_PAYSTATUS_PAY);
//        this.update(orderInfo);
//        //添加一条orderaction
//        OrderAction action = new OrderAction();
//        action.setOrderStatus(orderInfo.getOrderStatus());
//        action.setActionUser(orderInfo.getUser());
//        action.setShippingStatus(orderInfo.getShippingStatus());
//        action.setPayStatus(OrderInfo.ORDERINFO_PAYSTATUS_PAY);
//        action.setActionPlace("到家了");
//        action.setActionNote(remark);
//        action.setActionTime(new Date());
//        action.setOrder(orderInfo);
//        orderActionMapper.insert(action);
//    }
//
//}

package com.memory.shop.api.order.domain;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Setter
@Getter
@ToString
public class OrderAction extends BaseDomain  {

    //该订单商品所属的订单的id
    private OrderInfo order;
    //操作用户
    private Users actionUser;
    //订单状态
    private int orderStatus;
    //订单物流状态
    private int shippingStatus;
    //订单支付状态
    private int payStatus;
    //该操作的发出位置
    private String actionPlace;
    //操作日志
    private String actionNote;
    //操作时间
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date actionTime;



}
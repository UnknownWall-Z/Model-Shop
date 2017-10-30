package com.memory.shop.api.order.service;


import com.memory.shop.api.order.domain.OrderInfo;
import com.memory.shop.api.order.page.PageResult;
import com.memory.shop.api.order.query.OrderInfoQueryObject;

/**
 * Created by 76585 on 2017/10/10.
 */
public interface IOrderInfoService{
    void update(OrderInfo orderInfo);

    PageResult pageQuery(OrderInfoQueryObject qo);

    OrderInfo get(Long id);

    Long getUserId(Long id);

    void audit(Long id, int state, String remark);

    void auditFH(Long id, int state, String remark);

    void auditWCDD(Long id, int state, String remark);
}

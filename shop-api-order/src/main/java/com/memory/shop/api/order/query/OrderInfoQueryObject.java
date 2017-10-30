package com.memory.shop.api.order.query;


import com.memory.shop.api.order.util.DateUtil;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * Created by 76585 on 2017/10/10.
 */
@Setter
@Getter
public class OrderInfoQueryObject extends QueryObject {

    private String orderSn;
    private Integer orderState = -1;
    private Integer payState = -1;
    private Integer shippingState = -1;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date beginDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endDate;

    public Date getBeginDate() {
        return beginDate == null ? null : DateUtil.getBeginDate(beginDate);
    }

    public Date getEndDate() {
        return endDate == null ? null : DateUtil.getEndDate(endDate);
    }
}

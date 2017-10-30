package com.memory.shop.api.order.domain;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class OrderProduct extends BaseDomain {


    private OrderInfo orderId;

    /*private ProductSku skuId;
*/
    private String productName;

    private Integer productNumber;

    private Long productPrice;

    private String skuAttr;  //sku属性和属性值

}
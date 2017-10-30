package com.memory.shop.api.order.query;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * Created by 76585 on 2017/10/11.
 */
@Setter
@Getter
public class UsersQueryObject extends QueryObject {

    private String nickName;
    private BigDecimal minAccount;
    private BigDecimal maxAccount;
}

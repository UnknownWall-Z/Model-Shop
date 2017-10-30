package com.memory.shop.api.order.domain;

import java.io.Serializable;

/**
 * Created by 76585 on 2017/10/9.
 */
public class BaseDomain implements Serializable {
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}

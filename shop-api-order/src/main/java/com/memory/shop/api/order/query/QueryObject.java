package com.memory.shop.api.order.query;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * Created by 76585 on 2017/10/10.
 */
@Setter
@Getter
public class QueryObject implements Serializable {

    private Integer currentPage = 1;
    private Integer pageSize = 3;

    private Integer getBeginIndex(){
        return (this.currentPage - 1) * this.pageSize;
    }
}

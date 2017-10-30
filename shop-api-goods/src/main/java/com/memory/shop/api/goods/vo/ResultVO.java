package com.memory.shop.api.goods.vo;

import java.util.List;

/**
 * Created by zmh on 2017/10/12.
 */
public class ResultVO {
    private AddressVO defaultAddress;
    private List<ShoppingCarVO> items;

    public AddressVO getDefaultAddress() {
        return defaultAddress;
    }

    public void setDefaultAddress(AddressVO defaultAddress) {
        this.defaultAddress = defaultAddress;
    }

    public List<ShoppingCarVO> getItems() {
        return items;
    }

    public void setItems(List<ShoppingCarVO> items) {
        this.items = items;
    }
}

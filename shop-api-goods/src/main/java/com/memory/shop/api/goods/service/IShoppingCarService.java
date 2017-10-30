package com.memory.shop.api.goods.service;

import com.memory.shop.api.goods.domain.ShoppingCar;

import java.util.List;

/**
 * Created by zmh on 2017/10/12.
 */
public interface IShoppingCarService {
    int deleteByPrimaryKey(Long id);

    int insert(ShoppingCar record);

    ShoppingCar selectByPrimaryKey(Long id);

    int updateByPrimaryKey(ShoppingCar record);

    List<ShoppingCar> selectByUserId(Long userId);
}

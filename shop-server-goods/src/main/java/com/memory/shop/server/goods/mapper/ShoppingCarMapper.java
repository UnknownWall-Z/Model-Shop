package com.memory.shop.server.goods.mapper;

import com.memory.shop.api.goods.domain.ShoppingCar;

import java.util.List;

public interface ShoppingCarMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ShoppingCar record);

    ShoppingCar selectByPrimaryKey(Long id);

    int updateByPrimaryKey(ShoppingCar record);

    List<ShoppingCar> selectByUserId(Long userId);
}
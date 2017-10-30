package com.memory.shop.server.goods.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.memory.shop.api.goods.domain.ShoppingCar;
import com.memory.shop.api.goods.service.IShoppingCarService;
import com.memory.shop.server.goods.mapper.ShoppingCarMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by zmh on 2017/10/12.
 */
@Service
public class ShoppingCarServiceImpl implements IShoppingCarService {

    @Autowired
    private ShoppingCarMapper shoppingCarMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return shoppingCarMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(ShoppingCar record) {
        return shoppingCarMapper.insert(record);
    }

    @Override
    public ShoppingCar selectByPrimaryKey(Long id) {
        return shoppingCarMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKey(ShoppingCar record) {
        return shoppingCarMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<ShoppingCar> selectByUserId(Long userId) {
        return shoppingCarMapper.selectByUserId(userId);
    }
}

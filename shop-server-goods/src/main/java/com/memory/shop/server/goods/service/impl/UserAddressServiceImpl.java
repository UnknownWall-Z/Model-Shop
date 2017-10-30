package com.memory.shop.server.goods.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.memory.shop.api.goods.domain.UserAddress;
import com.memory.shop.api.goods.service.IUserAddressService;
import com.memory.shop.server.goods.mapper.UserAddressMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by zmh on 2017/10/12.
 */
@Service
public class UserAddressServiceImpl implements IUserAddressService {

    @Autowired
    private UserAddressMapper userAddressMapper;

    @Override
    public UserAddress selectDefaultAddress(Long id) {
        return userAddressMapper.selectDefaultAddress(id);
    }

    @Override
    public List<UserAddress> selectAddressList(Long userId) {
        return userAddressMapper.selectAddressList(userId);
    }

    @Override
    public UserAddress selectByPrimaryKey(Long id) {
        return userAddressMapper.selectDefaultAddress(id);
    }

    @Override
    public int updateByPrimaryKey(UserAddress record) {
        return userAddressMapper.updateByPrimaryKey(record);
    }

    @Override
    public int insert(UserAddress record) {
        return userAddressMapper.insert(record);
    }

    @Override
    public int deleteByPrimaryKey(Long id) {
        return userAddressMapper.deleteByPrimaryKey(id);
    }
}

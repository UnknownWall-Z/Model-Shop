package com.memory.shop.api.goods.service;

import com.memory.shop.api.goods.domain.UserAddress;

import java.util.List;

/**
 * Created by zmh on 2017/10/12.
 */
public interface IUserAddressService {
    UserAddress selectDefaultAddress(Long id);

    List<UserAddress> selectAddressList(Long userId);

    UserAddress selectByPrimaryKey(Long id);

    int updateByPrimaryKey(UserAddress record);

    int insert(UserAddress record);

    int deleteByPrimaryKey(Long id);
}

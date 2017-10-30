package com.memory.shop.server.goods.mapper;

import com.memory.shop.api.goods.domain.UserAddress;

import java.util.List;

public interface UserAddressMapper {
    int deleteByPrimaryKey(Long id);

    int insert(UserAddress record);

    UserAddress selectByPrimaryKey(Long id);

    int updateByPrimaryKey(UserAddress record);

    UserAddress selectDefaultAddress(Long id);

    List<UserAddress> selectAddressList(Long userId);
}
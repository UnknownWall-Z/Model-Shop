package com.memory.shop.server.order.mapper;


import com.memory.shop.api.order.domain.Users;
import com.memory.shop.api.order.query.UsersQueryObject;

import java.util.List;

public interface UsersMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Users record);

    Users selectByPrimaryKey(Long id);

    List<Users> selectAll();

    int updateByPrimaryKey(Users record);

    int getTotalCount(UsersQueryObject qo);

    List<Users> getListdata(UsersQueryObject qo);
}
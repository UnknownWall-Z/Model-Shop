package com.memory.shop.api.order.service;


import com.memory.shop.api.order.domain.Users;
import com.memory.shop.api.order.page.PageResult;
import com.memory.shop.api.order.query.UsersQueryObject;

/**
 * Created by 76585 on 2017/10/10.
 */
public interface IUsersService {

    Users selectByPrimaryKey(Long userId);

    PageResult pageQuery(UsersQueryObject qo);
}

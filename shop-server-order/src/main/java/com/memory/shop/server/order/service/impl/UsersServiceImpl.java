//package com.xmg.shop.server.order.service.impl;
//
//import com.alibaba.dubbo.config.annotation.Service;
//import com.memory.shop.api.order.domain.Users;
//import com.memory.shop.api.order.page.PageResult;
//import com.memory.shop.api.order.query.UsersQueryObject;
//import com.memory.shop.api.order.service.IUsersService;
//import com.memory.shop.server.order.mapper.UsersMapper;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import java.util.List;
//
///**
// * Created by 76585 on 2017/10/10.
// */
//@Service
//public class UsersServiceImpl implements IUsersService {
//
//    @Autowired
//    private UsersMapper usersMapper;
//
//    @Override
//    public Users selectByPrimaryKey(Long userId) {
//        return usersMapper.selectByPrimaryKey(userId);
//    }
//
//    @Override
//    public PageResult pageQuery(UsersQueryObject qo) {
//        int totalCount = this.usersMapper.getTotalCount(qo);
//        if (totalCount == 0){
//            return PageResult.empty(qo.getPageSize());
//        }
//        List<Users> listdata = this.usersMapper.getListdata(qo);
//        return new PageResult(listdata,totalCount,qo.getCurrentPage(),qo.getPageSize());
//    }
//}

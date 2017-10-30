package com.memory.shop.client.mgrsite.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.memory.shop.api.order.domain.OrderInfo;
import com.memory.shop.api.order.domain.Users;
import com.memory.shop.api.order.query.UsersQueryObject;
import com.memory.shop.api.order.service.IOrderInfoService;
import com.memory.shop.api.order.service.IUsersService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by 76585 on 2017/10/11.
 */
@Controller
public class UsersController {

    @Reference
    private IUsersService usersService;

    @Reference
    private IOrderInfoService infoService;

    @RequestMapping("/usersList")
    public String usersList(@ModelAttribute("qo")UsersQueryObject qo, Model model){
        model.addAttribute("pageResult",this.usersService.pageQuery(qo));
        return "users/usersList";
    }

    @RequestMapping("/userInfo")
    public String userInfo(Model model, Long id) {
        //通过id查询用户详情
        Users users = usersService.selectByPrimaryKey(id);
        model.addAttribute("users", users);
        //订单详情
        OrderInfo orderInfo = infoService.get(id);
        model.addAttribute("orderInfo", orderInfo);
        return "users/userinfo";
    }
}

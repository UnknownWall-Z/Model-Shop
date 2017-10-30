package com.memory.shop.client.mgrsite.controller;


import com.alibaba.dubbo.config.annotation.Reference;
import com.memory.shop.api.order.domain.OrderAction;
import com.memory.shop.api.order.domain.OrderInfo;
import com.memory.shop.api.order.domain.Users;
import com.memory.shop.api.order.query.OrderInfoQueryObject;
import com.memory.shop.api.order.service.IOrderActionService;
import com.memory.shop.api.order.service.IOrderInfoService;
import com.memory.shop.api.order.service.IUsersService;
import com.memory.shop.api.order.util.AjaxResult;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

/**
 * 订单列表总控制器
 * Created by 76585 on 2017/10/10.
 */
@Controller
public class OrderInfoController {

    @Reference
    private IOrderInfoService infoService;

    @Reference
    private IUsersService usersService;

    @Reference
    private IOrderActionService actionService;

    /*@Reference
    private IDistrictService districtService;*/

    @RequestMapping("/orderList")
    public String orderInfo(@ModelAttribute("qo") OrderInfoQueryObject qo, Model model) {
        model.addAttribute("pageResult", this.infoService.pageQuery(qo));
        return "order/orderList";
    }

    @RequestMapping("/invoiceList")
    public String sendOrder(@ModelAttribute("qo") OrderInfoQueryObject qo, Model model) {
        qo.setOrderState(OrderInfo.ORDERSTATUS_OK);
        model.addAttribute("pageResult", this.infoService.pageQuery(qo));
        return "order/orderSendList";
    }

    @RequestMapping("OKList")
    public String orderOK(@ModelAttribute("qo") OrderInfoQueryObject qo, Model model) {
        qo.setOrderState(OrderInfo.ORDERSTATUS_NOTOK);
        model.addAttribute("pageResult", this.infoService.pageQuery(qo));
        return "order/orderOKList";
    }

    @RequestMapping("/orderInfo")
    public String orderInfo(Model model, Long id) {
        //通过订单id查询出user
        Long userId = infoService.getUserId(id);
        //通过userID查询用户详情
        Users users = usersService.selectByPrimaryKey(userId);
        model.addAttribute("users", users);
        //订单详情
        OrderInfo orderInfo = infoService.get(id);
        model.addAttribute("orderInfo", orderInfo);
        List<OrderAction> actions = actionService.queryByOrderId(id);
        System.out.println(actions);
        model.addAttribute("actions", actions);
        return "order/order_info";
    }

    /*确认订单操作*/
    @RequestMapping("/orderInfoQRDD")
    @ResponseBody
    public AjaxResult audit1(Model model, String remark, Long id, int state) {
        AjaxResult result = new AjaxResult();
        try {
            infoService.audit(id, state, remark);
            List<OrderAction> actions = actionService.queryByOrderId(id);
            model.addAttribute("actions", actions);
            result = new AjaxResult(true, "操作成功！", new Date());

        } catch (Exception e) {
            result.setMsg(e.getMessage());
        }
        return result;

    }

    //发货操作
    @RequestMapping("/orderInfoFH")
    @ResponseBody
    public AjaxResult auditFH(Model model, String remark, Long id, int state) {
        AjaxResult result = new AjaxResult();
        try {
            infoService.auditFH(id, state, remark);
            List<OrderAction> actions = actionService.queryByOrderId(id);
            model.addAttribute("actions", actions);
            result = new AjaxResult(true, "操作成功！", new Date());

        } catch (Exception e) {
            result.setMsg(e.getMessage());
        }
        return result;


    }

    //完成订单操作
    @RequestMapping("/orderInfoWCDD")
    @ResponseBody
    public AjaxResult auditWCDD(Model model, String remark, Long id, int state) {
        AjaxResult result = null;
        try {
            infoService.auditWCDD(id, state, remark);
            List<OrderAction> actions = actionService.queryByOrderId(id);
            model.addAttribute("actions", actions);
            result = new AjaxResult(true, "操作成功！", new Date());

        } catch (Exception e) {
            result.setMsg(e.getMessage());
        }
        return result;
    }
}

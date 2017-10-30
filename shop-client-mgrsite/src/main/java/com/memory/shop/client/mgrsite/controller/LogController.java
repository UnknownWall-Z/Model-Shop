package com.memory.shop.client.mgrsite.controller;

import com.memory.shop.api.goods.query.LogQueryObject;
import com.memory.shop.api.goods.query.PageResult;
import com.memory.shop.api.goods.service.IlogService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by wall on 2017/10/13.
 */
@Controller
public class LogController {

    @com.alibaba.dubbo.config.annotation.Reference
    private IlogService logService;

    @RequestMapping("log")
    public String log(@ModelAttribute("qo")LogQueryObject qo, Model model){
        PageResult pageResult = logService.query(qo);
        model.addAttribute("pageResult",pageResult);
        return "log/log_list";
    }

    @RequestMapping("deleteLog")
    @ResponseBody
    public boolean deleteLog(){
        logService.removeAll();
        return true;
    }
}

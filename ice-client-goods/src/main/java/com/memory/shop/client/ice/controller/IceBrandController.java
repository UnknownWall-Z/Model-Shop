package com.memory.shop.client.ice.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.memory.ice.api.query.IceBrandQueryObject;
import com.memory.ice.api.query.PageResult;
import com.memory.ice.api.service.IceBrandService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class IceBrandController {

    @Reference
    private IceBrandService iceBrandService;

    @RequestMapping("iceBrand")
    public String brandList(@ModelAttribute("qo")IceBrandQueryObject qo, Model model){
        PageResult pageResult = iceBrandService.query(qo);
        List listData = pageResult.getListData();
        for (Object listDatum : listData) {
            System.out.println(listData);
        }
        model.addAttribute("pageResult",pageResult);
        return "brand/brand_list";
    }
}

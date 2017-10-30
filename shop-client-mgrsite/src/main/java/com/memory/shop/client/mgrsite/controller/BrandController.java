package com.memory.shop.client.mgrsite.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.memory.shop.api.goods.domain.Brand;
import com.memory.shop.api.goods.query.BrandQueryObject;
import com.memory.shop.api.goods.service.IBrandService;
import com.memory.shop.api.goods.vo.AjaxResult;
import com.memory.shop.client.mgrsite.util.UploadUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by zmh on 2017/10/9.
 */
@Controller
@RequestMapping("/brand")
public class BrandController {

    @Reference
    private IBrandService brandService;

    @RequestMapping
    public String brand(@ModelAttribute("qo") BrandQueryObject qo, Model model){
        model.addAttribute("pageResult",brandService.query(qo));
        return "brand/brand_list";
    }

    @RequestMapping("/get")
    @ResponseBody
    public Brand brand_get(Long id){
        return brandService.selectByPrimaryKey(id);
    }

    @RequestMapping("/save")
    @ResponseBody
    public AjaxResult brand_save(Brand brand){
        brandService.saveOrUpdate(brand);
        return new AjaxResult();
    }


    @RequestMapping("/uploadImage")
    @ResponseBody
    public String realAuthUploadImage(MultipartFile image){
        String fileName = UploadUtil.upload(image, "C:/Users/zmh/Desktop/Java/upload/");
        return fileName;
    }
}

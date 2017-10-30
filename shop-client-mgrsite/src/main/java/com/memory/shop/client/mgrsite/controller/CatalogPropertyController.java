package com.memory.shop.client.mgrsite.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.memory.shop.api.goods.domain.CatalogProperty;
import com.memory.shop.api.goods.domain.CatalogPropertyValue;
import com.memory.shop.api.goods.service.ICatalogPropertyService;
import com.memory.shop.api.goods.service.ICatalogPropertyValueService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by wall on 2017/10/9.
 */

/****
 * 商品属性测试列表
 */
@Controller
public class CatalogPropertyController {

    @Reference
    private ICatalogPropertyService catalogPropertyService;
    @Reference
    private ICatalogPropertyValueService catalogPropertyValueService;

    @RequestMapping("listCatalogProperty")
    @ResponseBody
    public List<CatalogProperty> catalogProperList() {
        return catalogPropertyService.list();
    }

    @RequestMapping("CatalogPropertyById")
    @ResponseBody
    public String catalogPropertyById() {
        return catalogPropertyService.get(3).toString();
    }

    /*@RequestMapping("catalog")
    public String catalog() {
        return "catalog/catalog";
    }*/

    @RequestMapping("catalogProperty")
    public String catalogProperty() {
        return "property/property";
    }

    @RequestMapping(value = "catalogProperty/get/{catalogId}", method = RequestMethod.GET)
    public String getCatalogPropertyValue(@PathVariable("catalogId") Long catalogId, Model model) {
        List<CatalogProperty> list = catalogPropertyService.getPropertyByCatalogId(catalogId);
        CatalogProperty catalogProperty = catalogPropertyService.get(catalogId);
        model.addAttribute("catalogProperty", catalogProperty);
        model.addAttribute("list", list);
        return "property/property_list";

//        List<CatalogPropertyValue> list = catalogPropertyValueService.catalogPropertyValueListByCatalogId(catalogId);
//        CatalogProperty catalogProperty = catalogPropertyService.get(catalogId);
//        model.addAttribute("list", list);
//        model.addAttribute("catalogProperty", catalogProperty);
//        return "property/property_value_list";
    }

    /***
     * 分类属性保存或强改
     * @param catalogProperty
     * @return
     */
    @RequestMapping("catalogProperty/add")
    @ResponseBody
    public boolean catalogList(CatalogProperty catalogProperty) {
        if(catalogProperty.getId()==null){
            catalogPropertyService.add(catalogProperty);
        }else{
            catalogPropertyService.update(catalogProperty);
        }
        return true;
    }

    /***
     * 分类属性删除
     * @param catalogProperty
     * @return
     */
    @RequestMapping("catalogProperty/delete")
    @ResponseBody
    public String catalogDelete(CatalogProperty catalogProperty){
        Long id = catalogProperty.getId();
        catalogPropertyValueService.deleteByPropertyId(id);
        catalogPropertyService.delete(id);
        return "";
    }

   @RequestMapping(value = "catalogPropertyValue/get/{catalogId}",method=RequestMethod.GET)
   public String valueList(@PathVariable("catalogId") Long catalogId, Model model){
       List<CatalogPropertyValue> list = catalogPropertyValueService.catalogPropertyValueListByCatalogId(catalogId);
        CatalogProperty catalogProperty = catalogPropertyService.get(catalogId);
        model.addAttribute("list", list);
        model.addAttribute("catalogProperty", catalogProperty);
        return "property/property_value_list";
   }

    /***
     * 分类属性编辑列表
     * @param catalogProperty
     * @param model
     * @return
     */
   @RequestMapping("catalogPropertyEdit/add")
   public String propertyAdd(CatalogProperty catalogProperty,Model model){

       if(catalogProperty.getId()!=-1){
           catalogProperty = catalogPropertyService.get(catalogProperty.getId());
           model.addAttribute("catalogProperty",catalogProperty);
       }

       return "property/property_save";
   }

    /***
     * 删除属性->值
     * @param valueId
     * @return
     */
    @RequestMapping(value="catalogPropertyValue/delete/{valueId}",method=RequestMethod.GET)
    @ResponseBody
    public String delete(@PathVariable("valueId") long valueId){
        catalogPropertyValueService.delete(valueId);
        return "";
    }

    /***
     * 保存属性->值
     * @param value
     * @param catalogPropertyId
     * @param sequence
     * @return
     */
    @RequestMapping("catalogPropertyValue/add")
    @ResponseBody
    public boolean add(String value,long catalogPropertyId,int sequence){
        try{
            catalogPropertyValueService.save(value,catalogPropertyId,sequence);
            return true;
        }catch (Exception e){
            return false;
        }
    }

}

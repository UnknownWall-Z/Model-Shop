package com.memory.shop.client.mgrsite.controller;


import com.alibaba.dubbo.config.annotation.Reference;
import com.memory.shop.api.goods.domain.Catalog;
import com.memory.shop.api.goods.service.ICatalogPropertyService;
import com.memory.shop.api.goods.service.ICatalogPropertyValueService;
import com.memory.shop.api.goods.service.ICatalogService;
import com.memory.shop.api.goods.vo.AjaxResult;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 商品分类控制器
 */
@Controller
public class CatalogController {

    @Reference
    private ICatalogService catalogService;

    @Reference
    private ICatalogPropertyService catalogPropertyService;

    @Reference
    private ICatalogPropertyValueService catalogPropertyValueService;

    /**
     * 进入商品分类主页
     *
     * @param model
     * @return
     */
    @RequestMapping(value ="catalog",method = RequestMethod.GET)
    public String catalog(Model model) {
        return "catalog/catalog";
    }

    /**
     * 查询所有的列表
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "catalog/get")
    @ResponseBody
    public List<Catalog> getCatalog(Long id){
        List<Catalog> list = new ArrayList<>();
        if(id == null){
            list = catalogService.getParents();
        }else {
            list = catalogService.getChineCatalogById(id);
        }
        return list;
    }

    @RequestMapping(value = "catalog/get/{id}")
    public String getOne(@PathVariable("id")Long id,Model model){
        model.addAttribute("catalog",catalogService.selectByPrimaryKey(id));
        return "catalog/catalog_input";
    }

    @RequestMapping(value = "catalog/delete/{id}")
    @ResponseBody
    public AjaxResult delete(@PathVariable("id")Long id,Model model){

        //此处切勿忘记同时删除sku属性和值
        Catalog catalog = catalogService.selectByPrimaryKey(id);
        Catalog parent = catalogService.selectByPrimaryKey(catalog.getParentCatalogId());
        if(parent != null){
            parent.setChildrenCatalogs(parent.getChildrenCatalogs() - 1);
            parent.setLastModifiedDate(new Date());
            catalogService.update(parent);
        }
        List<Long> ids = catalogPropertyService.getIdsByCatalogId(id);
        catalogPropertyValueService.deleteByCatalogPropertyIds(ids);
        catalogPropertyService.deleteByCatalogId(id);
        catalogService.delete(id);
        return new AjaxResult();
    }


    @RequestMapping("catalog/save")
    @ResponseBody
    public AjaxResult saveOrUpdate(Catalog catalog) {
        AjaxResult result = new AjaxResult();
        try {
            if (catalog.getId() == null) {
                if(catalog.getParentCatalogId() != null) {
                    Catalog parent = catalogService.selectByPrimaryKey(catalog.getParentCatalogId());
                    Integer maxLevel = catalogService.getMaxLevel();

                        catalog.setCreateDate(new Date());
                        catalog.setLevel(parent.getLevel() + 1);
                        catalog.setChildrenCatalogs(0);
                        catalog.setProducts(0);
                        catalog.setSequence(parent.getChildrenCatalogs() + 1);
                        if (catalog.getLevel() < maxLevel) {
                            catalog.setIsParent(true);
                            parent.setChildrenCatalogs(parent.getChildrenCatalogs() + 1);
                        } else {
                            catalog.setIsParent(false);
                            parent.setIsParent(true);
                            parent.setChildrenCatalogs(1);
                        }
                        parent.setLastModifiedDate(new Date());
                        catalogService.update(parent);
                    }else {
                        catalog.setChildrenCatalogs(0);
                        catalog.setIsParent(true);
                        catalog.setCreateDate(new Date());
                        catalog.setProducts(0);
                        catalog.setLevel(1);
                    }
                    catalogService.insert(catalog);
            }else {
                Catalog selectByPrimaryKey = catalogService.selectByPrimaryKey(catalog.getId());
                selectByPrimaryKey.setCode(catalog.getCode());
                selectByPrimaryKey.setName(catalog.getName());
                selectByPrimaryKey.setLastModifiedDate(catalog.getLastModifiedDate());
                catalogService.updateByPrimaryKey(selectByPrimaryKey);
            }
        } catch (Exception e) {
            e.printStackTrace();
            result.setMsg("保存或者修改失败");
        }
        return result;
    }




}

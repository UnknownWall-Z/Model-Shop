package com.memory.shop.client.mgrsite.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.memory.shop.api.goods.domain.CatalogProperty;
import com.memory.shop.api.goods.domain.ProductCatalogPropertyValue;
import com.memory.shop.api.goods.domain.ProductInfo;
import com.memory.shop.api.goods.query.PageResult;
import com.memory.shop.api.goods.query.ProductQueryObject;
import com.memory.shop.api.goods.service.*;
import com.memory.shop.api.goods.vo.AjaxResult;
import com.memory.shop.client.mgrsite.util.UploadUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * Created by zmh on 2017/9/28.
 */
@Controller
public class ProductController {

    @Reference
    private IProductService productService;
    @Reference
    private ICatalogService catalogService;
    @Reference
    private IBrandService brandService;
    @Reference
    private IProductDescServcie productDescServcie;
    @Reference
    private ICatalogPropertyService catalogPropertyService;
    @Reference
    private IProductImageService productImageService;
    @Reference
    private IProductCatalogPropertyValueService productPropertyValueService;

    @RequestMapping("/product/get")
    public String listAllProduct(@ModelAttribute("qo") ProductQueryObject qo,Model model){
        PageResult pageResult = productService.queryPage(qo);
        model.addAttribute("pageResult",pageResult);

        return "product/product_list";
    }

    @RequestMapping(value="/product/add",method = RequestMethod.GET)
    public String listAllProduct(Model model ){
        model.addAttribute("catalogs",catalogService.selectAll());
        model.addAttribute("brands",brandService.selectAll());
        return "product/product_input";
    }

    /**
     * 根据商品分类查出属性
     * @param catalogId
     * @param model
     * @return
     */
    @RequestMapping("/catalogProperty/propertyValue/get/{catalogId}")
    public String catalogProperty(@PathVariable("catalogId")Long catalogId, Model model){
        model.addAttribute("productCatalogPropertyList",catalogPropertyService.getPropertyByCatalogId(catalogId));
        return "product/catalog_property_panel";
    }

    /**
     * 根据商品id和分类id查找属性做回显
     * @param productId
     * @param model
     * @return
     */
    @RequestMapping("/catalogProperty/propertyValue/show/{productId}/{catalogId}")
    public String getCatalogPropertyByProductId(@PathVariable("productId")Long productId,@PathVariable("catalogId")Long catalogId, Model model){
        List<ProductCatalogPropertyValue> productPropertyValue = productPropertyValueService.selectByProductId(productId);
        List<CatalogProperty> productCatalogPropertyList = catalogPropertyService.getPropertyByCatalogId(catalogId);
         for (CatalogProperty catalogProperty : productCatalogPropertyList) {
            for (ProductCatalogPropertyValue propertyValue : productPropertyValue) {
                if (catalogProperty.getName().equals(propertyValue.getName())){
                    catalogProperty.setTempValue(propertyValue.getValue());
                  /* for (CatalogPropertyValue values : catalogProperty.getCatalogPropertyValues()) {
                        if (values.getValue().equals(propertyValue.getValue())){
                            catalogProperty.setTempValue(values.getId());
                        }
                   }*/
                }
            }
        }
        model.addAttribute("productCatalogPropertyList",productCatalogPropertyList);
        return "product/catalog_edit_property_panel";
    }

    /**
     * 保存商品
     * @param productInfo
     * @return
     */
    @RequestMapping("/product/addProduct")
    @ResponseBody
    public AjaxResult addProduct(ProductInfo productInfo){
        AjaxResult json = new AjaxResult();
        try {
            productService.insert(productInfo);
        }catch (Exception e){
            e.printStackTrace();
            json.setMsg(e.getMessage());
        }
        return json;
    }

    @RequestMapping("/product/uploadProductImage")
    @ResponseBody
    public String uploadImage(MultipartFile file){
        String fileName = UploadUtil.upload(file, "C:/Users/zmh/Desktop/Java/upload");
        return "/"+fileName;
    }

    @RequestMapping("/product/get/{productId}")
    public String showProduct(@PathVariable("productId")Long productId, Model model){
        try {

            model.addAttribute("product",productService.selectById(productId));
            model.addAttribute("productDesc",productDescServcie.selectByProductId(productId));
            model.addAttribute("productImageList",productImageService.selectByProductId(productId));
            model.addAttribute("propertyList", productPropertyValueService.selectByProductId(productId));

        }catch (Exception e){
            e.printStackTrace();

        }
        return "product/show_product";
    }


    @RequestMapping("/product/edit/{productId}")
    public String editProduct(@PathVariable("productId")Long productId, Model model){
        try {
            model.addAttribute("brands",brandService.selectAll());
            model.addAttribute("catalogs",catalogService.selectAll());
            model.addAttribute("product",productService.selectById(productId));
            model.addAttribute("productDesc",productDescServcie.selectByProductId(productId));
            model.addAttribute("productImages",productImageService.selectByProductId(productId));
        }catch (Exception e){
            e.printStackTrace();
        }
        return "product/product_edit";
    }

    /**
     * 更新商品信息
     * @param productInfo
     * @return
     */
    @RequestMapping("/product/updateProduct")
    @ResponseBody
    public AjaxResult editProduct(ProductInfo productInfo){
        AjaxResult json = new AjaxResult();
        try {
            productService.update(productInfo);
        }catch (Exception e){
            e.printStackTrace();
            json.setMsg(e.getMessage());
        }
        return json;
    }

}

package com.memory.shop.client.mgrsite.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.memory.shop.api.goods.domain.*;
import com.memory.shop.api.goods.service.IProductService;
import com.memory.shop.api.goods.service.IProductSkuService;
import com.memory.shop.api.goods.service.ISkuPropertyService;
import com.memory.shop.api.goods.service.ISkuPropertyValueService;
import com.memory.shop.api.goods.vo.AjaxResult;
import com.memory.shop.api.goods.vo.SkuGeneratorVo;
import com.memory.shop.api.goods.vo.SkuVO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by cyf on 2017/10/9.
 */
@Controller
public class SkuContoller {

	@Reference
	private ISkuPropertyService skuPropertyService;

	@Reference
	private ISkuPropertyValueService skuPropertyValueService;

	@Reference
	private IProductService productService;

	@Reference
	private IProductSkuService productSkuService;

	@RequestMapping("skuProperty")
	public String test() {
		return "sku/property";
	}


	//根据 分类id 查出对应的 sku属性值列表
	@RequestMapping("skuProperty/get/{id}")
	public String getTypeSku(@PathVariable("id") Long id, Model model) {
		model.addAttribute("list", skuPropertyService.selectSkuByCatalogId(id));
		return "sku/property_list";
	}

	//查询出要编辑的 sku属性
	@RequestMapping(value = "skuProperty/save", method = RequestMethod.GET)
	public String saveSkuProperty(Long id, Long catalogId, Model model) {
		SkuProperty skuProperty = this.skuPropertyService.selectSkuForEdit(id, catalogId);
		model.addAttribute("skuProperty", skuProperty);
		return "sku/property_save";
	}

	//保存新增或者修改的 SkuProperty属性
	@RequestMapping(value = "skuProperty/save", method = RequestMethod.POST)
	@ResponseBody
	public AjaxResult saveOrUpdate(SkuProperty skuProperty) {
		AjaxResult result = new AjaxResult();
		this.skuPropertyService.saveOrUpdate(skuProperty);
		return result;
	}

	//删除对应的 sku属性和对应的 value
	@RequestMapping("skuProperty/delete")
	@ResponseBody
	public void delete(Long id, Long catalogId) {
		this.skuPropertyService.delete(id);
	}

	@RequestMapping("skuPropertyValue/get/{id}")
	public String getPropertyValue(@PathVariable("id") Long id, Model model) {
		SkuProperty skuProperty = this.skuPropertyService.selectByPrimaryId(id);
		model.addAttribute("skuProperty", skuProperty);
		model.addAttribute("list", this.skuPropertyValueService.selectByPropertyId(id));
		return "sku/property_value_list";
	}

	@RequestMapping("skuPropertyValue/add")
	@ResponseBody
	public AjaxResult addSkuPropertyValue(Long id, @RequestParam(value = "values[]") String[] values) {
		AjaxResult result = new AjaxResult();
		this.skuPropertyValueService.updateSkuPropertyValue(id, values);
		return result;
	}

	//进入商品 sku生成页面
	@RequestMapping("productSku/{id}")
	public String GenerateProductSku(@PathVariable("id") Long id, Model model) {

		//要先判断是否已经生成了sku页面.并对其进行分发
		List<ProductSku> productSkuList = this.productSkuService.selectByProductId(id);
		if (productSkuList.size() > 0) {
			//已经生成sku
			model.addAttribute("productSkuList",productSkuList);
			model.addAttribute("skuPropertyList",this.productSkuService.getSkuPropertieList(productSkuList));
			return "product/sku_manage";

		} else {
			//没有生成 sku
			Product product = this.productService.selectById(id);
			model.addAttribute("product", product);
			List<SkuProperty> productSkus = this.skuPropertyService.selectSkuByCatalogId(product.getCatalog().getId());
			model.addAttribute("skuPropertyList", productSkus);
			return "product/sku_generate";
		}
	}

	//用选择的类别生成对应的sku property 值
	@RequestMapping("/productSku/skuPropertyValue/{skuPropertyId}")
	public String getSkuProperty(@PathVariable("skuPropertyId") Long skuPropertyId, Model model) {
		SkuProperty skuProperty = this.skuPropertyService.selectByPrimaryId(skuPropertyId);
		model.addAttribute("skuProperty", skuProperty);
		List<SkuPropertyValue> skuPropertyValues = this.skuPropertyValueService.selectByPropertyId(skuPropertyId);
		model.addAttribute("skuPropertyValue", skuPropertyValues);
		return "product/sku_property_value_table";
	}

	//生成sku属性
	@RequestMapping("/productSku/generateSku")
	public String generateSku(@RequestBody SkuGeneratorVo skuGeneratorVo, Model model) {
		model.addAttribute("skuPropertieList", this.productSkuService.getSkuPropertieList(skuGeneratorVo));
		model.addAttribute("skuList", this.productSkuService.generateSku(skuGeneratorVo));
		return "product/sku_form";
	}

	//保存商品sku
	@RequestMapping("productSku/save")
	@ResponseBody
	public AjaxResult saveProductSku(SkuVO skuVO) {
		System.out.println(skuVO);
		AjaxResult result = new AjaxResult();
		this.productSkuService.saveSku(skuVO);
		return result;
	}

}

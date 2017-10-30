package com.memory.shop.server.goods.service.impl;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.config.annotation.Service;
import com.memory.shop.api.goods.domain.*;
import com.memory.shop.api.goods.service.IProductService;
import com.memory.shop.api.goods.service.IProductSkuPropertyService;
import com.memory.shop.api.goods.service.IProductSkuService;
import com.memory.shop.api.goods.service.ISkuPropertyService;
import com.memory.shop.api.goods.vo.SkuGeneratorVo;
import com.memory.shop.api.goods.vo.SkuVO;
import com.memory.shop.server.goods.mapper.ProductSkuMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.*;


/**
 * Created by cyf on 2017/10/10.
 */

@Service
public class ProductSkuServiceImpl implements IProductSkuService {

	private static Logger logger =  LoggerFactory.getLogger(ProductSkuServiceImpl.class);

	@Autowired
	private ProductSkuMapper productSkuMapper;

	@Reference
	private IProductService productService;

	@Reference
	private ISkuPropertyService skuPropertyService;

	@Reference
	private IProductSkuPropertyService productSkuPropertyService;

	@Override
	public List<ProductSku> selectByProductId(Long id) {
		return this.productSkuMapper.selectByProductId(id);
	}

	/**
	 * @param skuGeneratorVo 生成generateForm需要的数据
	 */
	@Override
	public List<Map<String, Object>> generateSku(SkuGeneratorVo skuGeneratorVo) {

		Product product = this.productService.selectById(skuGeneratorVo.getProductId());
		List<SkuProperty> propertyList = skuGeneratorVo.getSkuPropertieList();
		List<SkuPropertyValue> valueList = skuGeneratorVo.getSkuPropertyValueList();

		//将属性值按照 property分类
		List<List<SkuPropertyValue>> valueClaasifiedList = new ArrayList<>(propertyList.size());
		if (propertyList.size() > 0) {
			for (int i = 0; i < propertyList.size(); i++) {
				List<SkuPropertyValue> speValueList = new ArrayList<>();
				for (int j = 0; j < valueList.size(); j++) {
					if (valueList.get(j).getSkuPropertyId() == propertyList.get(i).getId()) {
						speValueList.add(valueList.get(j));
					}
				}
				valueClaasifiedList.add(speValueList);
			}
		}
		System.out.println("================================" + valueClaasifiedList);

		//每一种 property的取一个值合并成一个sku
		List<List<SkuPropertyValue>> skuList = recurGenerList(valueClaasifiedList, new ArrayList<List<SkuPropertyValue>>(), new ArrayList<SkuPropertyValue>(),
				0);
		System.out.println(skuList);

		//将这个sku list转换成需要的 颜色=白色,尺寸=M格式--一个List<Map>

		ArrayList<Map<String, Object>> mapArrayList = new ArrayList<>();
		for (List<SkuPropertyValue> skuPropertyValues : skuList) {
			Map<String, Object> map = new HashMap<>();
			for (SkuPropertyValue propertyValue : skuPropertyValues) {
				SkuProperty skuProperty = skuPropertyService.selectByPrimaryId(propertyValue.getSkuPropertyId());
				System.out.println(skuProperty.getName() + "---------skuProperty__name-------------");
				map.put(skuProperty.getName(), propertyValue.getValue());
			}
			map.put("code", "测试code");
			map.put("price", new BigDecimal("100"));
			mapArrayList.add(map);
		}
		return mapArrayList;

	}


	/**
	 * 获取页面需要的skuProperty(属性全)
	 *
	 * @param skuGeneratorVo
	 * @return
	 */
	@Override
	public List<SkuProperty> getSkuPropertieList(SkuGeneratorVo skuGeneratorVo) {
		ArrayList<SkuProperty> skuProperties = new ArrayList<>();
		for (SkuProperty skuProperty : skuGeneratorVo.getSkuPropertieList()) {
			skuProperties.add(this.skuPropertyService.selectByPrimaryId(skuProperty.getId()));
		}
		return skuProperties;
	}


	/**
	 * @param valueClaasifiedList 递归求商品各种组合sku的list
	 * @param result              分好的待递归的集合
	 * @param list                递归结果集合
	 * @param count               暂存集合
	 * @return
	 */
	private List<List<SkuPropertyValue>> recurGenerList(List<List<SkuPropertyValue>> valueClaasifiedList,//分好的待递归的集合
	                                                    List<List<SkuPropertyValue>> result,//递归结果集合
	                                                    List<SkuPropertyValue> list,  //暂存集合
	                                                    int count) {
		//如果不是最后一个
		if (count < valueClaasifiedList.size() - 1) {
			for (int i = 0; i < valueClaasifiedList.get(count).size(); i++) {
				ArrayList<SkuPropertyValue> temp = new ArrayList<>(list);
				temp.add(valueClaasifiedList.get(count).get(i));
				recurGenerList(valueClaasifiedList, result, temp, count + 1);
			}
		}
		//如果是最后一个
		else if (count == valueClaasifiedList.size() - 1) {
			for (int i = 0; i < valueClaasifiedList.get(count).size(); i++) {
				ArrayList<SkuPropertyValue> temp = new ArrayList<>(list);
				temp.add(valueClaasifiedList.get(count).get(i));
				result.add(temp);
			}
		}
		return result;

	}

	/**
	 * 保存页面传过来的sku
	 *
	 * @param skuVO
	 */
	@Override
	public void saveSku(SkuVO skuVO) {

		//要判断这个商品没有生成过sku--这里没写

		if (skuVO != null) {
			Product product = skuVO.getProduct();
			List<ProductSku> productSkuList = skuVO.getProductSkuList();
			if (productSkuList != null && productSkuList.size() > 0) {
				for (ProductSku productSkuInput : productSkuList) {

					//如果这条数据没有删掉
					if (productSkuInput.getCode() != null) {
						ProductSku productSku = new ProductSku();
						productSku.setCode(productSkuInput.getCode());
						productSku.setPrice(productSkuInput.getPrice());
						productSku.setProduct(product);
						this.productSkuMapper.insert(productSku);

						List<ProductSkuProperty> productSkuPropertyList = productSkuInput.getProductSkuProperties();
						for (ProductSkuProperty productSkuPropertyInput : productSkuPropertyList) {
							ProductSkuProperty productSkuProperty = new ProductSkuProperty();
							productSkuProperty.setProductSkuId(productSku.getId());
							productSkuProperty.setSkuProperty(productSkuPropertyInput.getSkuProperty());
							productSkuProperty.setValue(productSkuPropertyInput.getValue());
							this.productSkuPropertyService.insert(productSkuProperty);
						}
					}
				}
			}
		}
	}


	@Override
	public Set<String> getSkuPropertieList(List<ProductSku> productSkuList) {

		Set<String> result = new HashSet<>();
		for (ProductSku productSku : productSkuList) {
			List<ProductSkuProperty> productSkuPropertyList = productSku.getProductSkuProperties();
			for (ProductSkuProperty productSkuProperty : productSkuPropertyList) {
				result.add(productSkuProperty.getSkuProperty().getName());
			}
		}
		return result;
	}

	@Override
	public ProductSku selectBySkuCode(String code) {
		return productSkuMapper.selectBySkuCode(code);
	}
}

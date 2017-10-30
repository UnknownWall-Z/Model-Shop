package com.memory.shop.api.goods.vo;

import com.memory.shop.api.goods.domain.SkuProperty;
import com.memory.shop.api.goods.domain.SkuPropertyValue;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by cyf on 2017/10/11.
 */
public class SkuGeneratorVo implements Serializable{

	private Long productId;
	private List<SkuProperty> skuPropertieList=new ArrayList<SkuProperty>();
	private List<SkuPropertyValue> skuPropertyValueList=new ArrayList<SkuPropertyValue>();

	@Override
	public String toString() {
		return "SkuGeneratorVo{" +
				"productId=" + productId +
				", skuPropertieList=" + skuPropertieList +
				", skuPropertyValueList=" + skuPropertyValueList +
				'}';
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public List<SkuProperty> getSkuPropertieList() {
		return skuPropertieList;
	}

	public void setSkuPropertieList(List<SkuProperty> skuPropertieList) {
		this.skuPropertieList = skuPropertieList;
	}

	public List<SkuPropertyValue> getSkuPropertyValueList() {
		return skuPropertyValueList;
	}

	public void setSkuPropertyValueList(List<SkuPropertyValue> skuPropertyValueList) {
		this.skuPropertyValueList = skuPropertyValueList;
	}
}

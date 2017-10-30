package com.memory.shop.api.goods.vo;

import com.memory.shop.api.goods.domain.Product;
import com.memory.shop.api.goods.domain.ProductSku;

import java.io.Serializable;
import java.util.List;

/**
 * Created by cyf on 2017/10/11.
 */
public class SkuVO implements Serializable {

	private Product product;
	private List<ProductSku> productSkuList;


	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public List<ProductSku> getProductSkuList() {
		return productSkuList;
	}

	public void setProductSkuList(List<ProductSku> productSkuList) {
		this.productSkuList = productSkuList;
	}

	@Override
	public String toString() {
		return "SkuVO{" +
				"product=" + product +
				", productSkuList=" + productSkuList +
				'}';
	}
}

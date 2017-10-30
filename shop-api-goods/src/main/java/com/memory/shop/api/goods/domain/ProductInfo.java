package com.memory.shop.api.goods.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/10/10 0010.
 */
public class ProductInfo implements Serializable{

    private Product product;
    private ProductDesc productDesc;
    private List<ProductCatalogPropertyValue> productCatalogPropertyValue = new ArrayList<ProductCatalogPropertyValue>();
    private List<ProductImage> productImages =new ArrayList<ProductImage>();

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public ProductDesc getProductDesc() {
        return productDesc;
    }

    public void setProductDesc(ProductDesc productDesc) {
        this.productDesc = productDesc;
    }

    public List<ProductCatalogPropertyValue> getProductCatalogPropertyValue() {
        return productCatalogPropertyValue;
    }

    public void setProductCatalogPropertyValue(List<ProductCatalogPropertyValue> productCatalogPropertyValue) {
        this.productCatalogPropertyValue = productCatalogPropertyValue;
    }

    public List<ProductImage> getProductImages() {
        return productImages;
    }

    public void setProductImages(List<ProductImage> productImages) {
        this.productImages = productImages;
    }
}

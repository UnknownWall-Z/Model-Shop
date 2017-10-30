package com.memory.shop.api.goods.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ProductSku implements Serializable{

    private Long id;

    private Product product;

    private String code;

    private BigDecimal price;

    private List<ProductSkuProperty> productSkuProperties=new ArrayList<ProductSkuProperty>();


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public List<ProductSkuProperty> getProductSkuProperties() {
        return productSkuProperties;
    }

    public void setProductSkuProperties(List<ProductSkuProperty> productSkuProperties) {
        this.productSkuProperties = productSkuProperties;
    }

    @Override
    public String toString() {
        return "ProductSku{" +
                "id=" + id +
                ", product=" + product +
                ", code='" + code + '\'' +
                ", price=" + price +
                ", productSkuProperties=" + productSkuProperties +
                '}';
    }
}
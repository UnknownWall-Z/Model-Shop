package com.memory.shop.api.goods.vo;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by zmh on 2017/10/12.
 */
public class ShoppingCarVO {
    private Long shoppingItemId;
    private List<String> imgUrl;
    private String productName;
    private String skuProperty;
    private BigDecimal price;
    private int number;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Long getShoppingItemId() {
        return shoppingItemId;
    }

    public void setShoppingItemId(Long shoppingItemId) {
        this.shoppingItemId = shoppingItemId;
    }

    public List<String> getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(List<String> imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getSkuProperty() {
        return skuProperty;
    }

    public void setSkuProperty(String skuProperty) {
        this.skuProperty = skuProperty;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}

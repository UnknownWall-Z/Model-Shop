package com.memory.shop.api.goods.domain;

import java.io.Serializable;

public class SkuPropertyValue implements Serializable{

    private Long id;

    private Long skuPropertyId;

    private String value;

    private Integer sequence;






    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSkuPropertyId() {
        return skuPropertyId;
    }

    public void setSkuPropertyId(Long skuPropertyId) {
        this.skuPropertyId = skuPropertyId;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Integer getSequence() {
        return sequence;
    }

    public void setSequence(Integer sequence) {
        this.sequence = sequence;
    }

    @Override
    public String toString() {
        return "SkuPropertyValue{" +
                "id=" + id +
                ", skuPropertyId=" + skuPropertyId +
                ", value='" + value + '\'' +
                ", sequence=" + sequence +
                '}';
    }
}
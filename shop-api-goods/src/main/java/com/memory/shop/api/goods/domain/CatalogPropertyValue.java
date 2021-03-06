package com.memory.shop.api.goods.domain;

import java.io.Serializable;

public class CatalogPropertyValue implements Serializable{

    private Long id;

    private CatalogProperty catalogProperty;

    private String value;

    private Integer sequence;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CatalogProperty getCatalogProperty() {
        return catalogProperty;
    }

    public void setCatalogProperty(CatalogProperty catalogProperty) {
        this.catalogProperty = catalogProperty;
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
        return "CatalogPropertyValue{" +
                "id=" + id +
                ", catalogPropertyId=" + catalogProperty +
                ", value='" + value + '\'' +
                ", sequence=" + sequence +
                '}';
    }
}
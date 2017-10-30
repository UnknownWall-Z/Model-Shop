package com.memory.shop.api.goods.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class SkuProperty implements Serializable{

    public static final int SKU_TYPE_INPUT = 0;
    public static final int SKU_TYPE_SELECT = 1;

    private Long id;

    private String name;

    private Long catalogId;

    private int type;

    private Integer sequence;

    private List<SkuPropertyValue> values= new ArrayList<SkuPropertyValue>();





    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(Long catalogId) {
        this.catalogId = catalogId;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public Integer getSequence() {
        return sequence;
    }

    public void setSequence(Integer sequence) {
        this.sequence = sequence;
    }

    public List<SkuPropertyValue> getValues() {
        return values;
    }

    public void setValues(List<SkuPropertyValue> values) {
        this.values = values;
    }

    @Override
    public String toString() {
        return "SkuProperty{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", catalogId=" + catalogId +
                ", type=" + type +
                ", sequence=" + sequence +
                ", values=" + values +
                '}';
    }
}
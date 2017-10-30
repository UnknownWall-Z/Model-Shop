package com.memory.shop.api.goods.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CatalogProperty implements Serializable{

    public static final byte TYPE_INPUT = 0;
    public static final byte TYPE_MANY = 1;
    public static final byte TYPE_DOWN = 2;

    private Long id;

    private Long catalog_id;

    private String name;

    private Integer sequence;

    private Byte type;

    private String tempValue;

    public String getTempValue() {
        return tempValue;
    }

    public void setTempValue(String tempValue) {
        this.tempValue = tempValue;
    }

    private List<CatalogPropertyValue> catalogPropertyValues= new ArrayList<CatalogPropertyValue>();

    public Long getCatalog_id() {
        return catalog_id;
    }

    public void setCatalog_id(Long catalog_id) {
        this.catalog_id = catalog_id;
    }

    public List<CatalogPropertyValue> getCatalogPropertyValues() {
        return catalogPropertyValues;
    }

    public void setCatalogPropertyValues(List<CatalogPropertyValue> catalogPropertyValues) {
        this.catalogPropertyValues = catalogPropertyValues;
    }

    public String getDisPlayType(){

        switch(type){
            case TYPE_INPUT:return"输入框";
            case TYPE_MANY:return"多选框";
            case TYPE_DOWN:return"下拉列表";
        }
        return "未知类型";
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCatalogId() {
        return catalog_id;
    }

    public void setCatalogId(Long catalogId) {
        this.catalog_id = catalogId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSequence() {
        return sequence;
    }

    public void setSequence(Integer sequence) {
        this.sequence = sequence;
    }

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "CatalogProperty{" +
                "id=" + id +
                ", catalog_id=" + catalog_id +
                ", name='" + name + '\'' +
                ", sequence=" + sequence +
                ", type=" + type +
                '}';
    }
}
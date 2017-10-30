package com.memory.shop.api.goods.domain;

import java.io.Serializable;
import java.util.Date;

public class Catalog implements Serializable{
    private Long id;

    private Date createDate;           //分类创建时间

    private Date lastModifiedDate;    //最后修改时间

    private int version;          //改分类的版本号

    private int level;             //分类级别

    private String name;              //分类名

    private String code;              //分类编码

    private int sequence;           //排序号

    private int childrenCatalogs;  //该分类下的子分类个数

    private int products;           //该分类下的商品个数

    private Long parentCatalogId;     //父分类ID

    private Boolean isParent;     //  该分类是否为父分类，1为是，0为否

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getSequence() {
        return sequence;
    }

    public void setSequence(Integer sequence) {
        this.sequence = sequence;
    }

    public Integer getChildrenCatalogs() {
        return childrenCatalogs;
    }

    public void setChildrenCatalogs(Integer childrenCatalogs) {
        this.childrenCatalogs = childrenCatalogs;
    }

    public Integer getProducts() {
        return products;
    }

    public void setProducts(Integer products) {
        this.products = products;
    }

    public Long getParentCatalogId() {
        return parentCatalogId;
    }

    public void setParentCatalogId(Long parentCatalogId) {
        this.parentCatalogId = parentCatalogId;
    }

    public Boolean getIsParent() {
        return isParent;
    }

    public void setIsParent(Boolean isParent) {
        this.isParent = isParent;
    }
}
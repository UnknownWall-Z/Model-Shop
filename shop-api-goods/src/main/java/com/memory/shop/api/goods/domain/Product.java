package com.memory.shop.api.goods.domain;



import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class Product implements Serializable {
    //上架
    public static final int MODS_SHELVES = 1;
    //推荐
    public static final int MODS_RECOMMENDED = 1<<1;

    private Long id;

    private Date createdDate;

    private Date lastModifiedDate = new Date();

    private Integer version;

    private String name;
    //商品关键字
    private String keyword;
    //商品编号
    private String code;

    private String image;

    private BigDecimal marketPrice;

    private BigDecimal basePrice;
    //状态
    private Long mods = 0L;
    //标签
    private String impressions;

    //分类
//    private List<Catalog> catalog = new ArrayList<Catalog>();
    private Catalog catalog = new Catalog();
    //品牌
    private Brand brand = new Brand();
    //是否上架
    private boolean shelves;
    //是否推荐
    private boolean recommended;

    public Long getMods() {
        if (shelves){
            this.mods = this.mods| MODS_SHELVES;
        }
        if (recommended){
            this.mods = this.mods| MODS_RECOMMENDED;
        }
        return this.mods;
    }

    public void setMods(Long mods) {
        this.mods = mods;
    }



    public boolean getShelves() {
        if ((this.mods & MODS_SHELVES) != 0){
             return true;
        }else{
            return false;
        }
    }

    public void setShelves(boolean shelves) {
        this.shelves = shelves;
    }

    public boolean getRecommended() {
        if ((this.mods & MODS_RECOMMENDED) != 0){
            return true;
        }else{
            return false;
        }
    }

    public void setRecommended(boolean recommended) {
        this.recommended = recommended;
    }

    public String getCatalogName(){
        return catalog.getName();
    }

    public String getBrandName(){
        return brand.getChineseName();
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
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

    public Catalog getCatalog() {
        return catalog;
    }

    public void setCatalog(Catalog catalog) {
        this.catalog = catalog;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public BigDecimal getMarketPrice() {
        return marketPrice;
    }

    public void setMarketPrice(BigDecimal marketPrice) {
        this.marketPrice = marketPrice;
    }

    public BigDecimal getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(BigDecimal basePrice) {
        this.basePrice = basePrice;
    }


    public String getImpressions() {
        return impressions;
    }

    public void setImpressions(String impressions) {
        this.impressions = impressions;
    }
}
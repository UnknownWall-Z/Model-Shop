package com.memory.shop.api.goods.domain;

import java.io.Serializable;

public class UserAddress implements Serializable{
    private Long id;

    private District province;

    private District city;

    private District district;

    private String detail;

    private Boolean isDefault;

    private Long userId;

    private String name;

    private String phone;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public District getProvince() {
        return province;
    }

    public void setProvince(District province) {
        this.province = province;
    }

    public District getCity() {
        return city;
    }

    public void setCity(District city) {
        this.city = city;
    }

    public District getDistrict() {
        return district;
    }

    public void setDistrict(District district) {
        this.district = district;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public Boolean getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(Boolean isDefault) {
        this.isDefault = isDefault;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
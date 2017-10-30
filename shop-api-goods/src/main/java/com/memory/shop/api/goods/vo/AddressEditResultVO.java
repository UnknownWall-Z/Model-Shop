package com.memory.shop.api.goods.vo;

import java.util.List;
import java.util.Map;

/**
 * Created by zmh on 2017/10/12.
 */
public class AddressEditResultVO {
    private Long addressId;
    private String deliverUser;
    private String deliverPhone;
    private String address;
    private List<Map<Long,String>> regionFirst;
    private List<Map<Long,String>> regionSec;
    private List<Map<Long,String>> regionThird;
    private Boolean isDefault;

    public Long getAddressId() {
        return addressId;
    }

    public void setAddressId(Long addressId) {
        this.addressId = addressId;
    }

    public String getDeliverUser() {
        return deliverUser;
    }

    public void setDeliverUser(String deliverUser) {
        this.deliverUser = deliverUser;
    }

    public String getDeliverPhone() {
        return deliverPhone;
    }

    public void setDeliverPhone(String deliverPhone) {
        this.deliverPhone = deliverPhone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Map<Long, String>> getRegionFirst() {
        return regionFirst;
    }

    public void setRegionFirst(List<Map<Long, String>> regionFirst) {
        this.regionFirst = regionFirst;
    }

    public List<Map<Long, String>> getRegionSec() {
        return regionSec;
    }

    public void setRegionSec(List<Map<Long, String>> regionSec) {
        this.regionSec = regionSec;
    }

    public List<Map<Long, String>> getRegionThird() {
        return regionThird;
    }

    public void setRegionThird(List<Map<Long, String>> regionThird) {
        this.regionThird = regionThird;
    }

    public Boolean getDefault() {
        return isDefault;
    }

    public void setDefault(Boolean aDefault) {
        isDefault = aDefault;
    }
}

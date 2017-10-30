package com.memory.shop.api.goods.vo;

/**
 * Created by zmh on 2017/10/12.
 */
public class AddressVO {
    private Long adressId;
    private String deliverUser;
    private String deliverPhone;
    private String deliverAddressFullString;

    public Long getAdressId() {
        return adressId;
    }

    public void setAdressId(Long adressId) {
        this.adressId = adressId;
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

    public String getDeliverAddressFullString() {
        return deliverAddressFullString;
    }

    public void setDeliverAddressFullString(String deliverAddressFullString) {
        this.deliverAddressFullString = deliverAddressFullString;
    }
}

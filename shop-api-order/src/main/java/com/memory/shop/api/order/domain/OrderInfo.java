package com.memory.shop.api.order.domain;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Setter
@Getter
public class OrderInfo extends BaseDomain {

    //订单编号
    private String orderSn;

    //下单用户的id
    private Users user;

    //订单状态
    private int orderStatus;

    //订单物流状态
    private int shippingStatus;

    //订单支付状态
    private int payStatus;

    //收货人名称
    private String consignee;


    //收货人省份
    private String province;

    //收货人城市
    private String city;

    //收获人市区
    private String district;

    //收货人地址
    private String address;

    //收货人邮政编码
    private String zipcode;

    //收货人联系电话
    private String mobile;

    //订单的总价
    private BigDecimal orderAmount;

    //创建订单的时间
    private Date orderDate;

    //发货时间
    private Date sendDate;

    //完成时间
    private Date finishDate;

    public static final int ORDERINFO_PAYSTATUS_PAY = 1; //已经付款
    public static final int ORDERINFO_PAYSTATUS_UNPAY =0; //未付款
    public static final int SHIPPINGSTATUS_UNSEND = 0;//未发货
    public static final int SHIPPINGSTATUS_SEND = 1;//已发货
    public static final int SHIPPINGSTATUS_RECEIVE = 2;//已收货
    public static final int ORDERSTATUS_NOTOK = 0;//未确认
    public static final int ORDERSTATUS_OK = 1;//已确认
    public static final int ORDERSTATUS_FINISH = 2;//已完成

    //支付状态
    public String getPayStatusDisplay(){
        return this.payStatus == ORDERINFO_PAYSTATUS_PAY  ? "已经付款" : "未付款";
    }

    //订单状态
    public String getOrderStatusDisplay(){
        switch (this.orderStatus){
            case ORDERSTATUS_NOTOK:return "未确认";
            case ORDERSTATUS_OK:return "已确认";
            case ORDERSTATUS_FINISH:return "已完成";
            default:return  "";
        }
    }

    //发货状态
    public String getShippingStatusDisplay(){
        switch (this.shippingStatus){
            case SHIPPINGSTATUS_UNSEND:return "未发货";
            case SHIPPINGSTATUS_SEND:return "已发货";
            case SHIPPINGSTATUS_RECEIVE:return "已收货";
            default:return  "";
        }
    }

   /* public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public String getOrderSn() {
        return orderSn;
    }

    public void setOrderSn(String orderSn) {
        this.orderSn = orderSn;
    }

    public Users getUserId() {
        return userId;
    }

    public void setUserId(Users userId) {
        this.userId = userId;
    }

    public int getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(int orderStatus) {
        this.orderStatus = orderStatus;
    }

    public int getShippingStatus() {
        return shippingStatus;
    }

    public void setShippingStatus(int shippingStatus) {
        this.shippingStatus = shippingStatus;
    }

    public int getPayStatus() {
        return payStatus;
    }

    public void setPayStatus(int payStatus) {
        this.payStatus = payStatus;
    }

    public String getConsignee() {
        return consignee;
    }

    public void setConsignee(String consignee) {
        this.consignee = consignee;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public BigDecimal getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(BigDecimal orderAmount) {
        this.orderAmount = orderAmount;
    }*/
}
package com.memory.shop.api.goods.vo;

/**
 * Created by zmh on 2017/10/13.
 */
public class OrderResultVO {
    private Boolean success = true;
    private String errorMsg;
    private int paymentType;

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.success = false;
        this.errorMsg = errorMsg;
    }

    public int getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(int paymentType) {
        this.paymentType = paymentType;
    }
}

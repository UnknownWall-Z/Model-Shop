package com.memory.shop.api.goods.vo;

/**
 * Created by zmh on 2017/10/12.
 */

public class AddressEditVO {
    private Boolean success = true;
    private String errorMsg;
    private AddressEditResultVO result;

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

    public AddressEditResultVO getResult() {
        return result;
    }

    public void setResult(AddressEditResultVO result) {
        this.result = result;
    }
}

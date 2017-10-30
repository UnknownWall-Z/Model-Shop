package com.memory.shop.api.goods.vo;

import java.util.List;

/**
 * Created by zmh on 2017/10/12.
 */
public class AddressListVO {
    private Boolean success = true;
    private String errorMsg;
    private List<AddressVO> result;

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

    public List<AddressVO> getResult() {
        return result;
    }

    public void setResult(List<AddressVO> result) {
        this.result = result;
    }
}

package com.memory.shop.api.goods.vo;

import java.math.BigDecimal;

/**
 * Created by zmh on 2017/10/12.
 */
public class SettleMentVO {
    private Boolean success = true;
    private String errorMsg;
    private ResultVO result;
    private BigDecimal totalPrice;

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

    public ResultVO getResult() {
        return result;
    }

    public void setResult(ResultVO result) {
        this.result = result;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }
}

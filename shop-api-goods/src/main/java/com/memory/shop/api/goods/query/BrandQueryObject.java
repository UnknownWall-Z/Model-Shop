package com.memory.shop.api.goods.query;

/**
 * Created by zmh on 2017/10/9.
 */
public class BrandQueryObject extends QueryObject{
    private String keyword;

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = "".equals(keyword.trim()) ? null : keyword;
    }
}

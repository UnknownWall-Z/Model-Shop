package com.memory.shop.api.order.domain;

public class District extends BaseDomain {

    private Short districtId;

    private Short pid;

    private String districtName;

    private Boolean level;

    private Boolean display;

    public Short getDistrictId() {
        return districtId;
    }

    public void setDistrictId(Short districtId) {
        this.districtId = districtId;
    }

    public Short getPid() {
        return pid;
    }

    public void setPid(Short pid) {
        this.pid = pid;
    }

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    public Boolean getLevel() {
        return level;
    }

    public void setLevel(Boolean level) {
        this.level = level;
    }

    public Boolean getDisplay() {
        return display;
    }

    public void setDisplay(Boolean display) {
        this.display = display;
    }
}
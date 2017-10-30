package com.memory.ice.api.domain;

import java.io.Serializable;

public class IceBrand implements Serializable{

    private Long id;

    private Integer version;

    private String chineseName;

    private String english;

    private String url;

    private String logo;

    private String telephone;

    private String remark;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getChineseName() {
        return chineseName;
    }

    @Override
    public String toString() {
        return "IceBrand{" +
                "id=" + id +
                ", version=" + version +
                ", chineseName='" + chineseName + '\'' +
                ", english='" + english + '\'' +
                ", url='" + url + '\'' +
                ", logo='" + logo + '\'' +
                ", telephone='" + telephone + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }

    public void setChineseName(String chinesename) {
        this.chineseName = chinesename;
    }

    public String getEnglish() {
        return english;
    }

    public void setEnglish(String english) {
        this.english = english;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
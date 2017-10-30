package com.memory.shop.api.goods.domain;

import java.io.Serializable;
import java.util.Date;

public class Log implements Serializable{
    private Long id;

    private String url;

    private String time;

    private Date date;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Log{" +
                "id=" + id +
                ", url='" + url + '\'' +
                ", time='" + time + '\'' +
                ", date=" + date +
                '}';
    }
}
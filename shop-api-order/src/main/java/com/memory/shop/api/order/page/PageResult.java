package com.memory.shop.api.order.page;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

/**
 * Created by 76585 on 2017/10/10.
 */
public class PageResult implements Serializable {
    private List<?> listdata;
    private Integer totalCount;
    private Integer prevPage;
    private Integer nextPage;
    private Integer totalPage;
    private Integer currentPage;
    private Integer pageSize;


    public PageResult(){}

    public PageResult(List<?> listdata,Integer totalCount,
                      Integer currentPage,Integer pageSize){
        this.listdata = listdata;
        this.pageSize = pageSize;
        this.currentPage = currentPage;
        this.totalCount = totalCount;
        this.totalPage = this.totalCount % this.pageSize == 0 ?
                this.totalCount / this.pageSize :
                this.totalCount / this.pageSize + 1;

        this.prevPage = this.currentPage - 1 >= 1 ? this.currentPage - 1 : 1;
        this.nextPage = this.currentPage + 1 <= this.totalPage ?
                this.currentPage + 1 : this.totalPage;
    }

    public static PageResult empty(Integer pageSize){
        return new PageResult(Collections.EMPTY_LIST,0,1,pageSize);
    }

    public Integer getCurrentPage() {
        return currentPage;
    }
    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }
    public Integer getPageSize() {
        return pageSize;
    }
    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
    public List getListdata() {
        return listdata;
    }
    public void setListData(List listdata) {
        this.listdata = listdata;
    }
    public Integer getTotalCount() {
        return totalCount;
    }
    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }
    public Integer getPrevPage() {
        return prevPage;
    }
    public void setPrevPage(Integer prevPage) {
        this.prevPage = prevPage;
    }
    public Integer getNextPage() {
        return nextPage;
    }
    public void setNextPage(Integer nextPage) {
        this.nextPage = nextPage;
    }
    public Integer getTotalPage() {
        return totalPage == 0 ? 1 : totalPage;
    }
    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

}

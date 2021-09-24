package com.bean;

import java.util.List;

/**
 * @author wxy
 * @title: Page
 * @description: TODO
 * @date 2021/7/2114:50
 */
public class Page <T>{
    private Integer totalPage;
    private Integer totalNum;
    private Integer currPageNum;
    private List<T> items;
    private Integer pageSize;
    private String url;
    public static final Integer DEFAULT_PAGE_SIZE = 4;


    public Page() {
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Page(Integer totalPage, Integer totalNum, Integer currPageNum, List<T> items, Integer pageSize) {
        this.totalPage = totalPage;
        this.totalNum = totalNum;
        this.currPageNum = currPageNum;
        this.items = items;
        this.pageSize = pageSize;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public Integer getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(Integer totalNum) {
        this.totalNum = totalNum;
    }

    public Integer getCurrPageNum() {
        return currPageNum;
    }

    public void setCurrPageNum(Integer currPageNum) {
        this.currPageNum = currPageNum;
    }

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    @Override
    public String toString() {
        return "Page{" +
                "totalPage=" + totalPage +
                ", totalNum=" + totalNum +
                ", currPageNum=" + currPageNum +
                ", items=" + items +
                ", pageSize=" + pageSize +
                ", url='" + url + '\'' +
                '}';
    }
}

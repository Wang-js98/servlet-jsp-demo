package com.qst.pojo;

import java.util.List;

public class Page<T> {
    public static final int PAGE_SIZE = 5;
    private List<T> data;  //封装的数据
    private int pageCount; //总页数
    private int currentPage; //当前页码

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }
}

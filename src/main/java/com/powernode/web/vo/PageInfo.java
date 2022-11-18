package com.powernode.web.vo;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PageInfo<E> {
    /**
     *  页面记录显示条数
     */
    private long pageSize;
    /**
     *  总记录条数
     */
    private long total;
    /**
     *  总页数
     */
    private long pageNums;

    private List<E> dataList;

    public long getTotal() {
        return total;
    }

    public long getPageSize() {
        return pageSize;
    }

    public void setPageSize(long pageSize) {
        this.pageSize = pageSize;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public long getPageNums() {
        return pageNums;
    }

    public void setPageNums(long pageNums) {
        this.pageNums = pageNums;
    }

    public List<E> getDataList() {
        return dataList;
    }

    public void setDataList(List<E> dataList) {
        this.dataList = dataList;
    }
}

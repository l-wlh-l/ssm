package com.wlh.ssm.domain;

import java.util.List;

/**
 * @ClassName PageBean
 * @Description TODO
 * @Author wlh
 * @Date 2019/3/5 20:57
 **/
public class PageBean<T> {
    private Long totalCount;
    private Integer pageNumber;
    private Integer pageSize;
    private Integer totalPage;
    private List<T> pageList;

    public Long getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Long totalCount) {
        this.totalCount = totalCount;
    }

    public Integer getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public List<T> getPageList() {
        return pageList;
    }

    public void setPageList(List<T> pageList) {
        this.pageList = pageList;
    }

    @Override
    public String toString() {
        return "PageBean{" +
                "totalCount=" + totalCount +
                ", pageNumber=" + pageNumber +
                ", pageSize=" + pageSize +
                ", totalPage=" + totalPage +
                ", pageList=" + pageList +
                '}';
    }
}

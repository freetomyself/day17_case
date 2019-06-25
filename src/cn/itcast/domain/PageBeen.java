package cn.itcast.domain;

import java.util.List;

/**
 * @program: 分页工具对象
 * @author: WaHotDog 2019-06-23 18:51
 **/


public class PageBeen<T> {
    private int totalCount;//总的记录数
    private int totalPage;//总页码
    private List<T> list;//每页数据
    private int currentPage;//当前页码
    private int rows;//每页显示的记录数

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    @Override
    public String  toString() {
        return "PageBeen{" +
                "totalCount=" + totalCount +
                ", totalPage=" + totalPage +
                ", list=" + list +
                ", current=" + currentPage +
                ", rows=" + rows +
                '}';
    }
}

/**
 * Copyright：中软海晟信息科技有限公司 版权所有 违者必究 2013 
 */
package com.cartan.core;

import java.io.Serializable;
import java.util.List;

public class Page
        implements Serializable
{
    protected boolean showAll;
    protected int pageStart;
    protected int pageSize;
    protected int rowsCount;
    protected int currentPage;
    protected int totalPage;
    protected List objects;

    public Page()
    {
        init();
    }

    public Page(boolean showAll)
    {
        init();
        this.showAll = showAll;
    }

    public Page(int currentPage, int pageSize)
    {
        init();
        if (currentPage < 1)
            this.currentPage = 1;
        else
            this.currentPage = currentPage;
        if (pageSize < 1)
            this.pageSize = 1;
        else
            this.pageSize = pageSize;
        changeStart();
    }

    protected void init()
    {
        this.showAll = false;
        this.pageSize = 20;
        this.rowsCount = 0;
        this.currentPage = 1;
        this.totalPage = 1;
        changeStart();
        changTotalPage();
    }

    protected void changeStart()
    {
        this.pageStart = ((this.currentPage <= 1) ? 1 : (this.currentPage - 1) * this.pageSize + 1);
    }

    public int getPageSize()
    {
        return this.pageSize;
    }

    public boolean isShowAll()
    {
        return this.showAll;
    }

    public int getRowsCount()
    {
        return this.rowsCount;
    }

    public int getPageStart()
    {
        return this.pageStart;
    }

    public int getTotalPage()
    {
        return this.totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
        changeStart();
        changTotalPage();
    }

    public void setShowAll(boolean showAll)
    {
        this.showAll = showAll;
    }

    public void setRowsCount(int rowsCount)
    {
        this.rowsCount = rowsCount;
        changTotalPage();
    }

    private void changTotalPage()
    {
        if (this.rowsCount > 0L)
            this.totalPage = ((this.rowsCount % this.pageSize <= 0) ? this.rowsCount / this.pageSize : this.rowsCount / this.pageSize + 1);
        else
            this.totalPage = 0;
        if (this.totalPage > 0)
            this.currentPage = ((this.currentPage <= this.totalPage) ? this.currentPage : this.totalPage);
    }

    public int getCurrentPage()
    {
        return this.currentPage;
    }

    public List getObjects() {
        return this.objects;
    }

    public void setCurrentPage(int currentPage)
    {
        this.currentPage = currentPage;
        changeStart();
    }

    public void setObjects(List objects) {
        this.objects = objects;
    }

    public void reset()
    {
        init();
    }
}
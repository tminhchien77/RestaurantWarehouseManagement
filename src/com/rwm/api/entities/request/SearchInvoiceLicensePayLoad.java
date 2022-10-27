package com.rwm.api.entities.request;

import com.rwm.api.entities.APIRequest;

import java.util.Date;


public class SearchInvoiceLicensePayLoad extends APIRequest {
    private Date fromDate;
    private Date toDate;
    private Integer searchType;
    private Integer isExport;
    private String keyword;

    public Date getFromDate() {
        return fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    public Date getToDate() {
        return toDate;
    }

    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }

    public Integer getSearchType() {
        return searchType;
    }

    public void setSearchType(Integer searchType) {
        this.searchType = searchType;
    }

    public Integer getIsExport() {
        return isExport;
    }

    public void setIsExport(Integer isExport) {
        this.isExport = isExport;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }



}

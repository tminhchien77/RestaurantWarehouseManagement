package com.rwm.api.entities.request;

import com.rwm.api.entities.APIRequest;

import java.util.Date;


public class SearchStoreCheckSheetPayLoad extends APIRequest {
    private Integer searchType;
    private Date fromDate;
    private Date toDate;
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

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }



}

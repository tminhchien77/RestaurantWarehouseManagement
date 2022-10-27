package com.rwm.api.entities.request;

import com.rwm.api.entities.APIRequest;

public class SearchItemPayLoad extends APIRequest {
    private Integer branchId;
    private Integer supplierId;
    private String keyword;


    public Integer getBranchid() {
        return branchId;
    }

    public void setBranchId(Integer branchId) {
        this.branchId = branchId;
    }
    public Integer getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Integer supplierId) {
        this.supplierId = supplierId;
    }
    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }



}

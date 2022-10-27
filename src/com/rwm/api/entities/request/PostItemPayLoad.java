package com.rwm.api.entities.request;

import com.rwm.api.dbresult.RGetBranch;
import com.rwm.api.entities.APIRequest;

import java.util.ArrayList;
import java.util.List;

public class PostItemPayLoad extends APIRequest {
    private String itemName;
    private Integer branchId;
    private Integer quantityUnitId;
    private String itemImgBase64;
    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Integer getBranchId() {
        return branchId;
    }

    public String getItemImgBase64() {
        return itemImgBase64;
    }

    public void setItemImgBase64(String itemImgBase64) {
        this.itemImgBase64 = itemImgBase64;
    }

    public void setBranchId(Integer branchId) {
        this.branchId = branchId;
    }

    public Integer getQuantityUnitId() {
        return quantityUnitId;
    }

    public void setQuantityUnitId(Integer quantityUnitId) {
        this.quantityUnitId = quantityUnitId;
    }

}

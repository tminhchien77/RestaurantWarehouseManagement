package com.rwm.api.entities.request;

import com.rwm.api.entities.APIRequest;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

public class PutItemPayLoad extends APIRequest {
    private Integer itemId;
    private String itemName;
    private Integer branchId;
    private String itemImgBase64;

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }
    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
    public Integer getBranchId() {
        return branchId;
    }

    public void setBranchId(Integer branchId) {
        this.branchId = branchId;
    }
    public String getItemImgBase64() {
        return itemImgBase64;
    }

    public void setItemImgBase64(String itemImgBase64) {
        this.itemImgBase64 = itemImgBase64;
    }

}

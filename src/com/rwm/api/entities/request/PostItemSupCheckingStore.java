package com.rwm.api.entities.request;

import com.rwm.api.entities.APIRequest;

import java.util.Date;

public class PostItemSupCheckingStore extends APIRequest {
    private String itemSupId;
    private Date expDate;
    private Float remainQuantity;

    public String getItemSupId() {
        return itemSupId;
    }

    public void setItemSupId(String itemSupId) {
        this.itemSupId = itemSupId;
    }

    public Date getExpDate() {
        return expDate;
    }

    public void setExpDate(Date expDate) {
        this.expDate = expDate;
    }

    public Float getRemainQuantity() {
        return remainQuantity;
    }

    public void setRemainQuantity(Float remainQuantity) {
        this.remainQuantity = remainQuantity;
    }
}

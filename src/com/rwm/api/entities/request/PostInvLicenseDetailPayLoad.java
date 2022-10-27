package com.rwm.api.entities.request;

import com.rwm.api.dbresult.RGetStoreHistoryDetailByItemIdsQuantities;
import com.rwm.api.entities.APIRequest;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PostInvLicenseDetailPayLoad extends APIRequest {
    private Integer serial;
    private String itemSupId;
    private Date proDate;
    private Date expDate;
    private Integer price;
    private Float quantity;

    public PostInvLicenseDetailPayLoad(int i, RGetStoreHistoryDetailByItemIdsQuantities itemSup) {
        this.serial = i;
        this.itemSupId = itemSup.getItemSupId();
        this.expDate = itemSup.getExpDate();
        this.quantity = itemSup.getQuantity();
    }

    public Integer getSerial() {
        return serial;
    }

    public void setSerial(Integer serial) {
        this.serial = serial;
    }

    public String getItemSupId() {
        return itemSupId;
    }

    public void setItemSupId(String itemSupId) {
        this.itemSupId = itemSupId;
    }

    public Date getProDate() {
        return proDate;
    }

    public void setProDate(Date proDate) {
        this.proDate = proDate;
    }

    public Date getExpDate() {
        return expDate;
    }

    public void setExpDate(Date expDate) {
        this.expDate = expDate;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Float getQuantity() {
        return quantity;
    }

    public void setQuantity(Float quantity) {
        this.quantity = quantity;
    }
}

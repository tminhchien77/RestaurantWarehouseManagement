package com.rwm.api.entities.request;

import com.rwm.api.entities.APIRequest;

import java.util.Date;

public class PostImExRequestDetailPayLoad extends APIRequest {
    private Integer itemId;
    private Float quantity;
    private Integer quantityUnitId;

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public Float getQuantity() {
        return quantity;
    }

    public void setQuantity(Float quantity) {
        this.quantity = quantity;
    }

    public Integer getQuantityUnitId() {
        return quantityUnitId;
    }

    public void setQuantityUnitId(Integer quantityUnitId) {
        this.quantityUnitId = quantityUnitId;
    }
}

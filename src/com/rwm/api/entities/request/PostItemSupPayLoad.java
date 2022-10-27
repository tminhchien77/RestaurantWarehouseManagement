package com.rwm.api.entities.request;

import com.rwm.api.entities.APIRequest;

public class PostItemSupPayLoad extends APIRequest {
    private Integer itemId;
    private Integer quantityUnitId;

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public Integer getQuantityUnitId() {
        return quantityUnitId;
    }

    public void setQuantityUnitId(Integer supplierId) {
        this.quantityUnitId = quantityUnitId;
    }
}

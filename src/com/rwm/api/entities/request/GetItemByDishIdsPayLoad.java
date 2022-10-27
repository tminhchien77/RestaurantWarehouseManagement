package com.rwm.api.entities.request;

import com.rwm.api.entities.APIRequest;

public class GetItemByDishIdsPayLoad extends APIRequest {
    private String dishIds;
    private String quantities;

    public String getDishIds() {
        return dishIds;
    }

    public void setDishIds(String dishIds) {
        this.dishIds = dishIds;
    }

    public String getQuantities() {
        return quantities;
    }

    public void setQuantities(String quantities) {
        this.quantities = quantities;
    }
}

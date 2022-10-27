package com.rwm.api.entities.request;

import com.rwm.api.entities.APIRequest;

import java.util.ArrayList;
import java.util.List;

public class PostItemSupsPayLoad extends APIRequest {
    private Integer itemId;
    private List<PostItemSupPayLoad> itemSups = new ArrayList<>();

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public List<PostItemSupPayLoad> getItemSups() {
        return itemSups;
    }

    public void setItemSups(List<PostItemSupPayLoad> itemSups) {
        this.itemSups = itemSups;
    }
}

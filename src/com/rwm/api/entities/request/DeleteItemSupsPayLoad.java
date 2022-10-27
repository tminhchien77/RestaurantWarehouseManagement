package com.rwm.api.entities.request;

import com.rwm.api.entities.APIRequest;

import java.util.ArrayList;
import java.util.List;

public class DeleteItemSupsPayLoad extends APIRequest {
    private List<String> itemSupIds=new ArrayList<>();

    public List<String> getItemSupIds() {
        return itemSupIds;
    }
}

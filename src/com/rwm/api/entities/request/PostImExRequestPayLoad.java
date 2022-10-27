package com.rwm.api.entities.request;

import com.rwm.api.entities.APIRequest;

import java.util.ArrayList;
import java.util.List;

public class PostImExRequestPayLoad extends APIRequest {
    private Integer createdUserId;
    private List<PostImExRequestDetailPayLoad> imExRequestDetails = new ArrayList<>();

    public Integer getCreatedUserId() {
        return createdUserId;
    }

    public void setCreatedUserId(Integer createdUserId) {
        this.createdUserId = createdUserId;
    }

    public List<PostImExRequestDetailPayLoad> getImExRequestDetails() {
        return imExRequestDetails;
    }

    public void setImExRequestDetails(List<PostImExRequestDetailPayLoad> imExRequestDetails) {
        this.imExRequestDetails = imExRequestDetails;
    }
}

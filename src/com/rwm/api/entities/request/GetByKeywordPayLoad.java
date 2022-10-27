package com.rwm.api.entities.request;

import com.rwm.api.entities.APIRequest;

public class GetByKeywordPayLoad extends APIRequest {
    private String keyword;

    public String getKeyword() {
        return keyword;
    }
}

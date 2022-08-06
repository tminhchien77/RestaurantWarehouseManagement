package com.rwm.api.entities.response;

import com.rwm.api.entities.ResponseData;

public class PostAccountResponseData extends ResponseData {

    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

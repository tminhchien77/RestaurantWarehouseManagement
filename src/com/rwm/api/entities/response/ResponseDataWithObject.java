package com.rwm.api.entities.response;

import com.rwm.api.entities.ResponseData;

public class ResponseDataWithObject extends ResponseData {

    private String message;

    private Object data;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

}

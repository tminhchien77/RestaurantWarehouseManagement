package com.hdv.api.entities.request;

import com.hdv.api.DTO.User;
import com.hdv.api.entities.APIRequest;

public class PostAccountPayLoad extends APIRequest {
    User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

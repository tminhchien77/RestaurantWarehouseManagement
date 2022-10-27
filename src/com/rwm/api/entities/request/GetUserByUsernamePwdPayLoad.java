package com.rwm.api.entities.request;

import com.rwm.api.entities.APIRequest;

public class GetUserByUsernamePwdPayLoad extends APIRequest {
    private String username;
    private String pwd;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}

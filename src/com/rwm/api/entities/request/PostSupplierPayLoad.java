package com.rwm.api.entities.request;

import com.rwm.api.entities.APIRequest;

import java.util.ArrayList;
import java.util.List;

public class PostSupplierPayLoad extends APIRequest {
    private String supplierName;
    private String address;
    private String phone;
    private String email;
    private String fax;
    private List<PostItemSupPayLoad> itemSups = new ArrayList<>();

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public List<PostItemSupPayLoad> getItemSups() {
        return itemSups;
    }

    public void setItemSups(List<PostItemSupPayLoad> itemSups) {
        this.itemSups = itemSups;
    }
}

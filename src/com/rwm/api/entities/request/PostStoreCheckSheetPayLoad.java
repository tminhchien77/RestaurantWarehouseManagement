package com.rwm.api.entities.request;

import com.rwm.api.entities.APIRequest;

import java.util.ArrayList;
import java.util.List;

public class PostStoreCheckSheetPayLoad extends APIRequest {
    private Integer createdUser;
    private String note;
    private List<PostItemSupCheckingStore> itemSupsCheckingStore = new ArrayList<>();

    public Integer getCreatedUser() {
        return createdUser;
    }

    public void setCreatedUser(Integer createdUser) {
        this.createdUser = createdUser;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public List<PostItemSupCheckingStore> getItemSupsCheckingStore() {
        return itemSupsCheckingStore;
    }

    public void setItemSupsCheckingStore(List<PostItemSupCheckingStore> itemSupsCheckingStore) {
        this.itemSupsCheckingStore = itemSupsCheckingStore;
    }
}

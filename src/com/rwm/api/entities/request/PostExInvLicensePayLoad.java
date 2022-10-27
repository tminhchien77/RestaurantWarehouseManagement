package com.rwm.api.entities.request;

import com.rwm.api.entities.APIRequest;

import java.util.ArrayList;
import java.util.List;

public class PostExInvLicensePayLoad extends APIRequest {
    private String invoiceLicenseId;
    private Float totalQuantity;
    private String note;
    private Integer isExport;
    private Integer createdUser;
    private String itemIds;
    private String quantities;

    public String getInvoiceLicenseId() {
        return invoiceLicenseId;
    }

    public void setInvoiceLicenseId(String invoiceLicenseId) {
        this.invoiceLicenseId = invoiceLicenseId;
    }

    public Float getTotalQuantity() {
        return totalQuantity;
    }

    public void setTotalQuantity(Float totalQuantity) {
        this.totalQuantity = totalQuantity;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Integer getIsExport() {
        return isExport;
    }

    public void setIsExport(Integer isExport) {
        this.isExport = isExport;
    }

    public Integer getCreatedUser() {
        return createdUser;
    }

    public void setCreatedUser(Integer createdUser) {
        this.createdUser = createdUser;
    }

    public String getItemIds() {
        return itemIds;
    }

    public void setItemIds(String itemIds) {
        this.itemIds = itemIds;
    }

    public String getQuantities() {
        return quantities;
    }

    public void setQuantities(String quantities) {
        this.quantities = quantities;
    }
}

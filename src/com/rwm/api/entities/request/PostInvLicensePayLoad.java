package com.rwm.api.entities.request;

import com.rwm.api.dbresult.RGetStoreHistoryDetailByItemIdsQuantities;
import com.rwm.api.entities.APIRequest;

import java.util.ArrayList;
import java.util.List;

public class PostInvLicensePayLoad extends APIRequest {
    private String invoiceLicenseId;
    private Float totalQuantity;
    private Integer payment;
    private String note;
    private Integer isExport;
    private Integer createdUser;
    private List<PostInvLicenseDetailPayLoad> invLicenseDetails = new ArrayList<>();

    public PostInvLicensePayLoad(PostExInvLicensePayLoad payload, List<RGetStoreHistoryDetailByItemIdsQuantities> itemSups) {
        this.invoiceLicenseId = payload.getInvoiceLicenseId();
        this.totalQuantity = payload.getTotalQuantity();
        this.note = payload.getNote();
        this.isExport = payload.getIsExport();
        this.createdUser = payload.getCreatedUser();
        int index=0;
        for (RGetStoreHistoryDetailByItemIdsQuantities itemSup: itemSups) {
            PostInvLicenseDetailPayLoad obj =new PostInvLicenseDetailPayLoad(++index,itemSup);
            this.invLicenseDetails.add(obj);
        }

    }

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

    public Integer getPayment() {
        return payment;
    }

    public void setPayment(Integer payment) {
        this.payment = payment;
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

    public List<PostInvLicenseDetailPayLoad> getInvLicenseDetails() {
        return invLicenseDetails;
    }

    public void setInvLicenseDetails(List<PostInvLicenseDetailPayLoad> invLicenseDetails) {
        this.invLicenseDetails = invLicenseDetails;
    }
}

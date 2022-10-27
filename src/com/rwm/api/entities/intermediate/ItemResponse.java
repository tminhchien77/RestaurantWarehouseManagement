package com.rwm.api.entities.intermediate;

import com.rwm.api.dbresult.DBResult;
import com.rwm.api.dbresult.RSearchItem;
import com.rwm.api.entities.request.PostItemSupPayLoad;
import org.apache.commons.codec.binary.Base64;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.rwm.api.utils.Const.defaultPath;

public class ItemResponse{
    private Integer ItemId;
    private String ItemName;
    private Integer QuantityUnitId;
    private String ItemImg;
    private Integer BranchId;
    private String BranchName;
    private Integer CountUsed;
    public ItemResponse(RSearchItem rSearchItem) throws IOException {
        this.setItemId(rSearchItem.getItemId());
        this.setItemName(rSearchItem.getItemName());
        this.setQuantityUnitId(rSearchItem.getQuantityUnitId());
        this.setBranchId(rSearchItem.getBranchId());
        this.setBranchName(rSearchItem.getBranchName());
        this.setItemImg(rSearchItem.getItemImg());
        this.setCountUsed(rSearchItem.getCountUsed());
    }

    public Integer getItemId() {
        return ItemId;
    }

    public void setItemId(Integer itemId) {
        ItemId = itemId;
    }

    public String getItemName() {
        return ItemName;
    }

    public void setItemName(String itemName) {
        ItemName = itemName;
    }

    public Integer getQuantityUnitId() {
        return QuantityUnitId;
    }

    public void setQuantityUnitId(Integer quantityUnitId) {
        QuantityUnitId = quantityUnitId;
    }

    public String getItemImg() {
        return ItemImg;
    }

    public void setItemImg(String itemImgFileName) throws IOException {
        System.out.println("itemImgFileName");
        System.out.println(itemImgFileName);
        if(!itemImgFileName.isEmpty()){
            File file =new File(defaultPath+itemImgFileName);
            FileInputStream fileInputStreamReader = new FileInputStream(file);
            byte[] bytes = new byte[(int)file.length()];
            fileInputStreamReader.read(bytes);
            ItemImg = new String(Base64.encodeBase64(bytes), "UTF-8");
        }
    }

    public Integer getBranchId() {
        return BranchId;
    }

    public void setBranchId(Integer branchId) {
        BranchId = branchId;
    }

    public String getBranchName() {
        return BranchName;
    }

    public void setBranchName(String branchName) {
        BranchName = branchName;
    }

    public Integer getCountUsed() {
        return CountUsed;
    }

    public void setCountUsed(Integer countUsed) {
        CountUsed = countUsed;
    }
}

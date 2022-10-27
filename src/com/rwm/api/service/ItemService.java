package com.rwm.api.service;

import com.rwm.api.dbresult.*;
import com.rwm.api.entities.intermediate.ItemResponse;
import com.rwm.api.entities.request.*;
import com.rwm.api.repository.ItemRepository;
import com.rwm.api.utils.CommonFunc;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static com.rwm.api.utils.Const.defaultPath;

public class ItemService {

    private static ItemService itemService = null;
    public static ItemService ins() {
        if (itemService == null) {
            itemService = new ItemService();
        }
        return itemService;
    }
    public static List<ItemResponse> searchItem(SearchItemPayLoad req) throws Exception {

        List<RSearchItem> listQuery = new ArrayList<>();
        listQuery = ItemRepository.searchItem(req);
        List<ItemResponse> resultList =new ArrayList<>();
        for (RSearchItem rSearchItem: listQuery) {
            resultList.add(new ItemResponse(rSearchItem));
        }
        return resultList;
    }
    public static void addItem (PostItemPayLoad req) throws Exception {
        if(req.getItemImgBase64().length()>0){
            String fileName = CommonFunc.imageHadle(req.getItemImgBase64());
            ItemRepository.addItem(req, fileName);
        }
        else{
            ItemRepository.addItem(req, "");
        }
        System.out.println("service");

    }

    public static List<RGetItemSup> getItemSupsByItemId(IntPayLoad req) throws Exception {
        return ItemRepository.getItemSupsByItemId(req);
    }

    public static void updItem (PutItemPayLoad req) throws Exception {
        if(req.getItemImgBase64().length()>0){
            String fileName = CommonFunc.imageHadle(req.getItemImgBase64());

            String oldFilePath = ItemRepository.updItem(req, fileName);
            File oldFile=new File(defaultPath+oldFilePath);
            oldFile.deleteOnExit();
        }
        else{
            ItemRepository.updItem(req, "");
        }
    }
    public static void addItemSups (PostItemSupsPayLoad req) throws Exception {
//        System.out.println("service");
//        ItemRepository.addItemSups(req.getItemId(), req.getItemSups());
    }
    public static void delItemSups (DeleteItemSupsPayLoad req) throws Exception {
        System.out.println("service");
        ItemRepository.delItemSups(req);
    }

    public static List<RGetItemByDishIds> getItemByDishIds(GetItemByDishIdsPayLoad req) throws Exception {
        List<RGetItemByDishIds> listQuery = new ArrayList<>();
        listQuery = ItemRepository.getItemByDishIds(req);
        List<RGetItemByDishIds> resultList =new ArrayList<>();
        for (RGetItemByDishIds item: listQuery) {
            resultList.add(item);
        }
        return resultList;
    }

    public static List<RGetAllItem> getAllItem() throws Exception {
        return ItemRepository.getAllItem();
    }

    public static void delItem(IntPayLoad req) throws Exception {
        ItemRepository.delItem(req);
    }
}

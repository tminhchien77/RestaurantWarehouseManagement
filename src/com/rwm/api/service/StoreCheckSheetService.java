package com.rwm.api.service;

import com.rwm.api.dbresult.RGetSupplier;
import com.rwm.api.dbresult.RSearchStoreCheckSheet;
import com.rwm.api.dbresult.RSearchSupplier;
import com.rwm.api.entities.request.*;
import com.rwm.api.repository.StoreCheckSheetRepository;
import com.rwm.api.repository.SupplierRepository;

import java.util.List;

public class StoreCheckSheetService {

    private static StoreCheckSheetService storeCheckSheetService = null;
    public static StoreCheckSheetService ins() {
        if (storeCheckSheetService == null) {
            storeCheckSheetService = new StoreCheckSheetService();
        }
        return storeCheckSheetService;
    }
    public static void addStoreCheckSheet(PostStoreCheckSheetPayLoad request) throws Exception {
        StoreCheckSheetRepository.fullAddStoreCheckSheet(request);
    }

    public static List<RSearchStoreCheckSheet> searchStoreCheckSheet(SearchStoreCheckSheetPayLoad request) throws Exception {
        return StoreCheckSheetRepository.searchStoreCheckSheet(request);
    }
}

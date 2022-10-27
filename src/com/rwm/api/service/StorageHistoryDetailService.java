package com.rwm.api.service;

import com.rwm.api.dbresult.RGetStoreHistoryByItemId;
import com.rwm.api.dbresult.RGetStoreHistoryDetailByCheckSheetId;
import com.rwm.api.dbresult.RSearchStoreHistoryDetail;
import com.rwm.api.entities.request.GetByKeywordPayLoad;
import com.rwm.api.entities.request.IntPayLoad;
import com.rwm.api.repository.StorageHistoryRepository;

import java.util.List;

public class StorageHistoryDetailService {

    private static StorageHistoryDetailService storageHistoryService = null;
    public static StorageHistoryDetailService ins() {
        if (storageHistoryService == null) {
            storageHistoryService = new StorageHistoryDetailService();
        }
        return storageHistoryService;
    }

    public static List<RGetStoreHistoryByItemId> getStoreHistoryByItemId(IntPayLoad req) throws Exception {
        System.out.println("Service");
        return StorageHistoryRepository.getStoreHistoryByItemId(req);
    }

    public static List<RSearchStoreHistoryDetail> searchStoreHistoryDetail(GetByKeywordPayLoad req) throws Exception {
        return StorageHistoryRepository.searchStoreHistoryDetail(req);
    }

    public static List<RGetStoreHistoryDetailByCheckSheetId> getStoreHistoryDetailByCheckSheetId(IntPayLoad req) throws Exception {
        return StorageHistoryRepository.getStoreHistoryDetailByCheckSheetId(req);
    }
}

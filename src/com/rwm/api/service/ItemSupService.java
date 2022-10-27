package com.rwm.api.service;

import com.rwm.api.dbresult.RGetItemSupsBySupplierId;
import com.rwm.api.entities.request.*;
import com.rwm.api.repository.ItemSupRepository;

import java.util.List;

public class ItemSupService {

    private static ItemSupService itemSupService = null;
    public static ItemSupService ins() {
        if (itemSupService == null) {
            itemSupService = new ItemSupService();
        }
        return itemSupService;
    }
    public static List<RGetItemSupsBySupplierId> getItemSupsBySupplierId(IntPayLoad req) throws Exception {
        System.out.println("Service");
        return ItemSupRepository.getItemSupsBySupplierId(req);
    }

}

package com.rwm.api.service;

import com.rwm.api.dbresult.RGetDish;
import com.rwm.api.entities.request.PostImExRequestPayLoad;
import com.rwm.api.entities.request.PostItemPayLoad;
import com.rwm.api.repository.DishRepository;
import com.rwm.api.repository.ImExRequestRepository;
import com.rwm.api.repository.ItemRepository;
import com.rwm.api.utils.CommonFunc;

import java.util.List;

public class ImExRequestService {

    private static ImExRequestService imExRequestService = null;
    public static ImExRequestService ins() {
        if (imExRequestService == null) {
            imExRequestService = new ImExRequestService();
        }
        return imExRequestService;
    }
    public static void addImExRequest (PostImExRequestPayLoad req) throws Exception {
        ImExRequestRepository.fullAddImExRequest(req);

    }
}

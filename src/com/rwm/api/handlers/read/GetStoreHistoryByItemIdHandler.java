package com.rwm.api.handlers.read;


import com.rwm.api.dbresult.RGetStoreHistoryByItemId;
import com.rwm.api.entities.request.IntPayLoad;
import com.rwm.api.entities.response.ResponseDataWithObject;
import com.rwm.api.handlers.APIHandler;
import com.rwm.api.resources.I18n;
import com.rwm.api.service.StorageHistoryDetailService;
import com.rwm.api.utils.Global;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;
import java.util.stream.Collectors;

public class GetStoreHistoryByItemIdHandler extends APIHandler<IntPayLoad, ResponseDataWithObject> {

    static {
        System.setProperty("file.encoding", "UTF-8");
        TimeZone.setDefault(TimeZone.getTimeZone(System.getProperty("time.zone", "Asia/Ho_Chi_Minh")));
    }

    public GetStoreHistoryByItemIdHandler() {
        super(IntPayLoad.class);
    }

    @Override
    protected ResponseDataWithObject handle(IntPayLoad request) throws Exception {
        ResponseDataWithObject response = new ResponseDataWithObject();
        List<RGetStoreHistoryByItemId> listQuery = new ArrayList<>();
        listQuery = StorageHistoryDetailService.getStoreHistoryByItemId(request);
        List<Map<String,Object>> data = listQuery.stream().map(RGetStoreHistoryByItemId::getValueMap).collect(Collectors.toList());
        response.setData(data);
        I18n.load(Global.locale);
        String message = I18n.get("getInvLicenseDetailByInvLicenseIdSuccess");
        response.setMessage(message);
        return response;

    }
}

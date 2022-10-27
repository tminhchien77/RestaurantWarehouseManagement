package com.rwm.api.handlers.read;



import com.rwm.api.dbresult.RGetStoreHistoryDetailByCheckSheetId;
import com.rwm.api.dbresult.RSearchStoreHistoryDetail;
import com.rwm.api.entities.request.GetByKeywordPayLoad;
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

public class GetStoreHistoryDetailByCheckSheetIdHandler extends APIHandler<IntPayLoad, ResponseDataWithObject> {

    static {
        System.setProperty("file.encoding", "UTF-8");
        TimeZone.setDefault(TimeZone.getTimeZone(System.getProperty("time.zone", "Asia/Ho_Chi_Minh")));
    }

    public GetStoreHistoryDetailByCheckSheetIdHandler() {
        super(IntPayLoad.class);
    }

    @Override
    protected ResponseDataWithObject handle(IntPayLoad request) throws Exception {
        ResponseDataWithObject response = new ResponseDataWithObject();
        List<RGetStoreHistoryDetailByCheckSheetId> listQuery =new ArrayList<>();
        listQuery = StorageHistoryDetailService.getStoreHistoryDetailByCheckSheetId(request);
        List<Map<String,Object>> data = listQuery.stream().map(RGetStoreHistoryDetailByCheckSheetId::getValueMap).collect(Collectors.toList());
        response.setData(data);
        I18n.load(Global.locale);
        String message = I18n.get("getStoreHistoryDetailByCheckSheetIdSuccess");
        response.setMessage(message);
        return response;

    }
}
